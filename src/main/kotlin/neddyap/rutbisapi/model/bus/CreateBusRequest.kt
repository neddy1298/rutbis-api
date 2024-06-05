package neddyap.rutbisapi.model.bus

import jakarta.validation.constraints.NotBlank

data class CreateBusRequest (

    @field:NotBlank
    val busId: String,

    @field:NotBlank
    val busLicense: String?,

    @field:NotBlank
    val busName: String?,

    @field:NotBlank
    val busIcon: String?,

    @field:NotBlank
    val busImage: String?,
)