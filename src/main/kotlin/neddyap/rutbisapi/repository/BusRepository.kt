package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.Bus
import org.springframework.data.jpa.repository.JpaRepository

interface BusRepository: JpaRepository<Bus, String>