package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.Terminal
import org.springframework.data.jpa.repository.JpaRepository

interface TerminalRepository: JpaRepository<Terminal, String>