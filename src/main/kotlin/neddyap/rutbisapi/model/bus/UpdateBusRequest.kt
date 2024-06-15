package neddyap.rutbisapi.model.bus

import jakarta.validation.constraints.NotBlank

data class UpdateBusRequest(

    @field:NotBlank
    val busLicense: String?,

    @field:NotBlank
    val busName: String?,

    @field:NotBlank
    val busIcon: Int?,

    @field:NotBlank
    val busImage: String?,
)