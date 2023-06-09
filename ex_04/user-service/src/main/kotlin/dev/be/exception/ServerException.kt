package dev.be.exception

sealed class ServerException(
    val code: Int,
    override val message: String,
) : RuntimeException(message)

data class UserExistException(
    override val message: String = "이미 존재하는 유저입니다"
) : ServerException(409, message)

data class UserNotFoundException(
    override val message: String = "존재하지 않는 회원입니다"
) : ServerException(404, message)

data class PasswordNotMatchedException(
    override val message: String = "비밀번호가 일치하지 않습니다"
) : ServerException(400, message)

data class InvalidJwtTokenException(
    override val message: String = "유효하지 않은 토큰입니다"
) : ServerException(400, message)