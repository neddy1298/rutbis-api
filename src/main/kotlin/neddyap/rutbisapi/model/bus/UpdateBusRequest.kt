package neddyap.rutbisapi.model.bus

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateBusRequest(

    @field:NotBlank
    val busLicense: String?,

    @field:NotBlank
    val busName: String?,

    @field:NotBlank
    val busIcon: String?,

    @field:NotBlank
    val busImage: String?,

    @field:NotNull
    @field:Min(value = 1)
    val price: Long?,
)