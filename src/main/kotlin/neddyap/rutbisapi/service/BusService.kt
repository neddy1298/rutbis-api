package neddyap.rutbisapi.service

import neddyap.rutbisapi.model.bus.BusResponse
import neddyap.rutbisapi.model.bus.UpdateBusRequest
import neddyap.rutbisapi.model.bus.CreateBusRequest
import neddyap.rutbisapi.model.bus.ListBusRequest

interface BusService {

    fun create(createBusRequest: CreateBusRequest): BusResponse

    fun get(id: String): BusResponse

    fun update(id: String, updateBusRequest: UpdateBusRequest): BusResponse

    fun delete(id: String)

    fun list(listBusRequest: ListBusRequest): List<BusResponse>
}