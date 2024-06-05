package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.BusTerminal
import org.springframework.data.jpa.repository.JpaRepository

interface BusTerminalRepository : JpaRepository<BusTerminal, String>