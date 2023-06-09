package dev.be.exception

import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.mono
import mu.KotlinLogging
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.toMono

@Configuration
class GlobalExceptionHandler(private val objectMapper: ObjectMapper) : ErrorWebExceptionHandler {

    private val logger = KotlinLogging.logger{}

    // 모노로 반환
    // 코루틴 -> 모노로 변환하기 위한 코루틴 빌더 필요 (mono)
    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> = mono {

        logger.error { ex.message }

        val errorResponse = if (ex is ServerException) {
            ErrorResponse(code = ex.code, message = ex.message)
        } else {
            ErrorResponse(code = 500, message = "Internal Server Error")
        }

        with(exchange.response) {
            statusCode = HttpStatus.OK
            headers.contentType = MediaType.APPLICATION_JSON

            val dataBuffer = bufferFactory().wrap(objectMapper.writeValueAsBytes(errorResponse))
            writeWith(dataBuffer.toMono()).awaitSingle()
        }

    }
}