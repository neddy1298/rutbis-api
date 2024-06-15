package neddyap.rutbisapi.service.impl

import neddyap.rutbisapi.error.NotFoundException
import neddyap.rutbisapi.entity.Journey
import neddyap.rutbisapi.model.journey.JourneyResponse
import neddyap.rutbisapi.model.journey.CreateJourneyRequest
import neddyap.rutbisapi.model.journey.ListJourneyRequest
import neddyap.rutbisapi.model.journey.UpdateJourneyRequest
import neddyap.rutbisapi.repository.BusRepository
import neddyap.rutbisapi.repository.JourneyRepository
import neddyap.rutbisapi.repository.TerminalRepository
import neddyap.rutbisapi.service.JourneyService
import neddyap.rutbisapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import java.util.stream.Collectors

@Service
class JourneyServiceImpl(
    val journeyRepository: JourneyRepository,
    val busRepository: BusRepository,
    val terminalRepository: TerminalRepository,
    val validationUtil: ValidationUtil
): JourneyService {
    override fun create(createJourneyRequest: CreateJourneyRequest): JourneyResponse {

        validationUtil.validate(createJourneyRequest)

        val bus = busRepository.findById(createJourneyRequest.busId!!)
            .orElseThrow { NotFoundException() }

        val terminal = terminalRepository.findById(createJourneyRequest.terminalId!!)
            .orElseThrow { NotFoundException() }

        val journey = Journey(
            busId = bus,
            terminalId = terminal,
            price = createJourneyRequest.price!!,
            departureTime = createJourneyRequest.departureTime!!,
            arrivalTime = createJourneyRequest.arrivalTime!!,
            createdAt = Date(),
            updatedAt = null
        )

        journeyRepository.save(journey)

        return convertJourneyToJourneyResponse(journey)
    }

    override fun get(id: String): JourneyResponse {
        val journey = findJourneyByIdOrThrowNotFound(id)

        return convertJourneyToJourneyResponse(journey)

    }

    override fun update(id: String, updateJourneyRequest: UpdateJourneyRequest): JourneyResponse {
        val journey = findJourneyByIdOrThrowNotFound(id)

        validationUtil.validate(updateJourneyRequest)

        journey.apply {
            busId = updateJourneyRequest.busId
            terminalId = updateJourneyRequest.terminalId
            price = updateJourneyRequest.price!!
            departureTime = updateJourneyRequest.departureTime!!
            arrivalTime = updateJourneyRequest.arrivalTime!!
            updatedAt = Date()
        }

        journeyRepository.save(journey)

        return convertJourneyToJourneyResponse(journey)
    }

    override fun delete(id: String) {
        val journey = findJourneyByIdOrThrowNotFound(id)
        journeyRepository.delete(journey)
    }

    override fun list(listJourneyRequest: ListJourneyRequest): List<JourneyResponse> {
        val page = journeyRepository.findAll(PageRequest.of(listJourneyRequest.page, listJourneyRequest.size))

        val journeys: List<Journey> = page.get().collect(Collectors.toList())

        return journeys.map { convertJourneyToJourneyResponse(it) }
    }

    override fun listByBusId(busId: String): List<JourneyResponse> {
        val bus = busRepository.findByIdOrNull(busId)
            ?: throw NotFoundException()

        val journeys = journeyRepository.findByBusId(bus)

        return journeys.map { convertJourneyToJourneyResponse(it) }
    }

    override fun listByTerminalId(terminalId: String): List<JourneyResponse> {
        val terminal = terminalRepository.findByIdOrNull(terminalId)
            ?: throw NotFoundException()

        val journeys = journeyRepository.findByTerminalId(terminal)

        return journeys.map { convertJourneyToJourneyResponse(it) }
    }

    private fun findJourneyByIdOrThrowNotFound(id: String): Journey {
        val journey = journeyRepository.findByIdOrNull(id)
        if (journey == null) {
            throw NotFoundException()
        }else{
            return journey
        }
    }

    private fun convertJourneyToJourneyResponse(journey: Journey): JourneyResponse {
        return JourneyResponse(
            journeyId = journey.journeyId,
            busId = journey.busId,
            terminalId = journey.terminalId,
            price = journey.price,
            departureTime = journey.departureTime.time.toString(),
            arrivalTime = journey.arrivalTime.time.toString(),
            createdAt = Date(),
            updatedAt = null
        )
    }
}