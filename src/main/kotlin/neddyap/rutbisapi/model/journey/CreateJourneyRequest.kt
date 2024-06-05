package neddyap.rutbisapi.model.journey

import jakarta.persistence.Id
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.sql.Time

data class CreateJourneyRequest (

    @field:NotBlank
    val journeyId: Id?,

    @field:NotBlank
    val busId: String?,

    @field:NotBlank
    val terminalId: String?,

    @field:NotNull
    @Min(1)
    val price: Long?,

    @field:NotBlank
    val departureTime: Time?,

    @field:NotBlank
    val arrivalTime: Time?,
)