package neddyap.rutbisapi.controller

import neddyap.rutbisapi.model.*
import neddyap.rutbisapi.model.journey.CreateJourneyRequest
import neddyap.rutbisapi.model.journey.JourneyResponse
import neddyap.rutbisapi.model.journey.ListJourneyRequest
import neddyap.rutbisapi.model.journey.UpdateJourneyRequest
import neddyap.rutbisapi.service.JourneyService
import org.springframework.web.bind.annotation.*

@RestController
class JourneyController(val journeyService: JourneyService) {

    @PostMapping(
        value = ["/api/journey"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createJourney(@RequestBody body: CreateJourneyRequest): WebResponse<JourneyResponse> {
        val journeyResponse = journeyService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = journeyResponse
        )
    }

    @GetMapping(
        value = ["/api/journey/{journeyId}"],
        produces = ["application/json"]
    )
    fun getJourney(@PathVariable("journeyId") id: String): WebResponse<JourneyResponse>{
        val journeyResponse = journeyService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = journeyResponse
        )
    }

    @PutMapping(
        value = ["/api/journey/{journeyId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateJourney(@PathVariable("journeyId") id: String, @RequestBody updateJourneyRequest: UpdateJourneyRequest): WebResponse<JourneyResponse>{
        val journeyResponse = journeyService.update(id, updateJourneyRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = journeyResponse
        )
    }

    @DeleteMapping(
        value = ["/api/journey/{journeyId}"],
        produces = ["application/json"]
    )
    fun deleteJourney(@PathVariable("journeyId") id: String): WebResponse<String>{
        journeyService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/journeys"],
        produces = ["application/json"]
    )
    fun listJourney(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0")page: Int): WebResponse<List<JourneyResponse>>{
        val request = ListJourneyRequest(page = page, size = size)
        val responses = journeyService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

    @GetMapping(
        value = ["/api/journeys/bus/{busId}"],
        produces = ["application/json"]
    )
    fun listJourneyByBus(@PathVariable("busId") busId: String): WebResponse<List<JourneyResponse>>{
        val responses = journeyService.listByBusId(busId)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

    @GetMapping(
        value = ["/api/journeys/terminal/{terminalId}"],
        produces = ["application/json"]
    )
    fun listJourneyByTerminal(@PathVariable("terminalId") terminalId: String): WebResponse<List<JourneyResponse>>{
        val responses = journeyService.listByTerminalId(terminalId)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

}