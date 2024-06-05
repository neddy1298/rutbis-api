package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.Journey
import org.springframework.data.jpa.repository.JpaRepository

interface JourneyRepository : JpaRepository<Journey, String>