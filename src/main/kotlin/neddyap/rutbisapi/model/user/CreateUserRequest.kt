package neddyap.rutbisapi.model.user

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class CreateUserRequest (

    @field:NotBlank
    val userId: String,

    @field:NotBlank
    val userName: String?,

    @field:NotBlank
    val userEmail: String?,

    @field:NotBlank
    val userPassword: String?,

    @field:NotNull
    val userAvatar: Int?,
)