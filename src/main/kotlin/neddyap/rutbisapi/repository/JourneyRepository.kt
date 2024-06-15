package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.Bus
import neddyap.rutbisapi.entity.Journey
import neddyap.rutbisapi.entity.Terminal
import org.springframework.data.jpa.repository.JpaRepository

interface JourneyRepository : JpaRepository<Journey, String> {
    fun findByBusId(bus: Bus): List<Journey>
    fun findByTerminalId(terminal: Terminal): List<Journey>
}