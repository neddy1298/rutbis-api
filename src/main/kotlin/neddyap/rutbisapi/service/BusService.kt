package neddyap.rutbisapi.service

import neddyap.rutbisapi.model.BusResponse
import neddyap.rutbisapi.model.UpdateBusRequest
import neddyap.rutbisapi.model.CreateBusRequest
import neddyap.rutbisapi.model.ListBusRequest

interface BusService {

    fun create(createBusRequest: CreateBusRequest): BusResponse

    fun get(id: String): BusResponse

    fun update(id: String, updateBusRequest: UpdateBusRequest): BusResponse

    fun delete(id: String)

    fun list(listBusRequest: ListBusRequest): List<BusResponse>
}