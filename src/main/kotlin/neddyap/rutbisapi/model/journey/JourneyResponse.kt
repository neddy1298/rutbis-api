package neddyap.rutbisapi.model.journey

import neddyap.rutbisapi.entity.Bus
import neddyap.rutbisapi.entity.Terminal
import java.util.*

data class JourneyResponse (

        val journeyId: String,
        val busId: Bus,
        val terminalId: Terminal,
        val price: Long,
        val departureTime: String,
        val arrivalTime: String,
        val createdAt: Date,
        val updatedAt: Date?
)