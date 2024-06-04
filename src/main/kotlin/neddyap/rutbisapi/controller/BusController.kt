package neddyap.rutbisapi.controller

import neddyap.rutbisapi.model.*
import neddyap.rutbisapi.service.BusService
import org.springframework.web.bind.annotation.*

@RestController
class BusController(val busService: BusService) {

    @PostMapping(
        value = ["/api/bus"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createBusId(@RequestBody body: CreateBusRequest): WebResponse<BusResponse> {
        val busResponse = busService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = busResponse
        )
    }

    @GetMapping(
        value = ["/api/buses/{busId}"],
        produces = ["application/json"]
    )

    fun getBus(@PathVariable("busId") id: String): WebResponse<BusResponse>{
        val busResponse = busService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = busResponse
        )
    }

    @PutMapping(
        value = ["/api/buses/{busId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateBus(@PathVariable("busId") id: String, @RequestBody updateBusRequest: UpdateBusRequest): WebResponse<BusResponse>{
        val busResponse = busService.update(id, updateBusRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = busResponse
        )
    }

    @DeleteMapping(
        value = ["/api/buses/{busId}"],
        produces = ["application/json"]
    )
    fun deleteBus(@PathVariable("busId") id: String): WebResponse<String>{
        busService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/buses"],
        produces = ["application/json"]
    )
    fun listBus(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0")page: Int): WebResponse<List<BusResponse>>{
        val request = ListBusRequest(page = page, size = size)
        val responses = busService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

}