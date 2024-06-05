package neddyap.rutbisapi.service

import neddyap.rutbisapi.model.journey.CreateJourneyRequest
import neddyap.rutbisapi.model.journey.JourneyResponse
import neddyap.rutbisapi.model.journey.ListJourneyRequest
import neddyap.rutbisapi.model.journey.UpdateJourneyRequest

interface JourneyService {

    fun create(createJourneyRequest: CreateJourneyRequest): JourneyResponse

    fun get(id: String): JourneyResponse

    fun update(id: String, updateJourneyRequest: UpdateJourneyRequest): JourneyResponse

    fun delete(id: String)

    fun list(listJourneyRequest: ListJourneyRequest): List<JourneyResponse>
}