package dev.be.service

import com.auth0.jwt.interfaces.DecodedJWT
import dev.be.config.JWTProperties
import dev.be.domain.entity.User
import dev.be.domain.repository.UserRepository
import dev.be.exception.InvalidJwtTokenException
import dev.be.exception.PasswordNotMatchedException
import dev.be.exception.UserExistException
import dev.be.exception.UserNotFoundException
import dev.be.model.SignInRequest
import dev.be.model.SignInResponse
import dev.be.model.SignUpRequest
import dev.be.utils.BCryptUtils
import dev.be.utils.JWTClaim
import dev.be.utils.JwtUtils
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class UserService(
    private val userRepository: UserRepository,
    private val jwtProperties: JWTProperties,
    private val cacheManager: CoroutineCacheManager<User>,
) {

    companion object {
        private val CACHE_TTL = Duration.ofMinutes(1)
    }

    suspend fun signUp(signUpRequest : SignUpRequest) {
        with(signUpRequest) {
            userRepository.findByEmail(email)?.let {
                throw UserExistException()
            }
            val user = User(
                email = email,
                password = BCryptUtils.hash(password),
                username = username
            )
            userRepository.save(user)
        }
    }

    suspend fun signIn(signInRequest: SignInRequest) : SignInResponse {
        return with(userRepository.findByEmail(signInRequest.email) ?: throw UserNotFoundException()) {
            val verified = BCryptUtils.verify(signInRequest.password, password)
            if (!verified) {
                throw PasswordNotMatchedException()
            }

            val jwtClaim = JWTClaim(
                userId = id!!,
                email = email,
                profileUrl = profileUrl,
                username = username
            )

            val token = JwtUtils.createToken(jwtClaim, jwtProperties)

            cacheManager.awaitPut(key = token, value = this, ttl = CACHE_TTL)
            SignInResponse(
                email = email,
                username = username,
                token = token
            )
        }
    }

    suspend fun logout(token : String) {
        cacheManager.awaitEvict(token)
    }

    suspend fun getByToken(token: String) : User {
        val cachedUser = cacheManager.awaitGetOrPut(key = token, ttl = CACHE_TTL) {
            // 캐시가 유효하지 않을 경우
            val decodedJWT : DecodedJWT = JwtUtils.decode(token, jwtProperties.secret, jwtProperties.issuer)

            val userId = decodedJWT.claims["userId"]?.asLong() ?: throw InvalidJwtTokenException()
            get(userId)
        }
        return cachedUser
    }

    suspend fun get(userId : Long) : User {
        return userRepository.findById(userId) ?: throw UserNotFoundException()
    }

    suspend fun edit(token: String, username: String, profileUrl: String?) : User {
        val user = getByToken(token)
        val newUser = user.copy(username = username, profileUrl = profileUrl ?: user.profileUrl)

        return userRepository.save(newUser).also {
            cacheManager.awaitPut(key = token, value = it, ttl = CACHE_TTL)
        }
    }

}