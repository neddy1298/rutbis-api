package neddyap.rutbisapi.model.journey

import jakarta.persistence.Id
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import neddyap.rutbisapi.entity.Bus
import neddyap.rutbisapi.entity.Terminal
import java.sql.Time

data class UpdateJourneyRequest(

    @field:NotBlank
    val journeyId: Id?,

    @field:NotBlank
    val busId: Bus,

    @field:NotBlank
    val terminalId: Terminal,

    @field:NotNull
    @Min(1)
    val price: Long?,

    @field:NotBlank
    val departureTime: Time?,

    @field:NotBlank
    val arrivalTime: Time?,
)