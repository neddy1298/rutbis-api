package neddyap.rutbisapi.controller

import jakarta.validation.ConstraintViolationException
import neddyap.rutbisapi.error.NotFoundException
import neddyap.rutbisapi.error.UnauthorizedException
import neddyap.rutbisapi.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String>{
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "Not Found"
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebResponse<String>{
        return WebResponse(
            code = 404,
            status = "UNAUTHORIZED",
            data = "Please put your API Key in the header X-Api-Key"
        )
    }
}