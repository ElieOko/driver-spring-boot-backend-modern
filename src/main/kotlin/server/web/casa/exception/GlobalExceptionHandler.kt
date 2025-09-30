package elieoko.spring.boot.core.exception

import jakarta.persistence.EntityNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import server.web.casa.exception.ErrorResponseDto
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)
    @ExceptionHandler(Exception::class)
    fun handleGenericException(e : Exception): ResponseEntity<ErrorResponseDto>{
        logger.error("Handle exception", e)
        val errorDto = ErrorResponseDto(
            "Internal server error",
            e.message.toString(),
            LocalDateTime.now()
        )
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(errorDto)
    }

    @ExceptionHandler(value = [EntityNotFoundException::class])
    fun handleEntityNotFound(e: EntityNotFoundException): ResponseEntity<ErrorResponseDto>{
        logger.error("Handle entityNotFoundException", e);
        val errorDto = ErrorResponseDto(
            "Entity not found",
            e.message.toString(),
            LocalDateTime.now()
        )

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(errorDto)
    }

    @ExceptionHandler(value = [
        IllegalArgumentException::class,
        IllegalStateException::class,
        MethodArgumentNotValidException::class
    ])
    fun handleBadRequest(e : Exception) : ResponseEntity<ErrorResponseDto>{
        logger.error("Handle handleBadRequest", e);
        val errorDto = ErrorResponseDto(
            "Bad request",
            e.message.toString(),
            LocalDateTime.now()
        )
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errorDto)
    }

}