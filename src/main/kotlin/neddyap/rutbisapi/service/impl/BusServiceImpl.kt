package neddyap.rutbisapi.service.impl

import neddyap.rutbisapi.error.NotFoundException
import neddyap.rutbisapi.model.UpdateBusRequest
import neddyap.rutbisapi.repository.BusRepository
import neddyap.rutbisapi.entity.Bus
import neddyap.rutbisapi.model.BusResponse
import neddyap.rutbisapi.model.CreateBusRequest
import neddyap.rutbisapi.model.ListBusRequest
import neddyap.rutbisapi.service.BusService
import neddyap.rutbisapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import java.util.stream.Collectors

@Service
class BusServiceImpl(
    val busRepository: BusRepository,
    val validationUtil: ValidationUtil
): BusService {
    override fun create(createBusRequest: CreateBusRequest): BusResponse {

        validationUtil.validate(createBusRequest)

        val bus = Bus(
            busId = createBusRequest.busId,
            busLicense = createBusRequest.busLicense!!,
            busName = createBusRequest.busName!!,
            busIcon = createBusRequest.busIcon!!,
            busImage = createBusRequest.busImage!!,
            price = createBusRequest.price!!,
            journeyList = createBusRequest.journeyList!!,
            createdAt = Date(),
            updatedAt = null
        )

        busRepository.save(bus)

        return convertBusToBusResponse(bus)
    }

    override fun get(id: String): BusResponse {
        val bus = findBusByIdOrThrowNotFound(id)

        return convertBusToBusResponse(bus)

    }

    override fun update(id: String, updateBusRequest: UpdateBusRequest): BusResponse {
        val bus = findBusByIdOrThrowNotFound(id)

        validationUtil.validate(updateBusRequest)

        bus.apply {
            busLicense = updateBusRequest.busLicense!!
            busName = updateBusRequest.busName!!
            busIcon = updateBusRequest.busIcon!!
            busImage = updateBusRequest.busImage!!
            price = updateBusRequest.price!!
            journeyList = updateBusRequest.journeyList!!
            updatedAt = Date()
        }

        busRepository.save(bus)

        return convertBusToBusResponse(bus)
    }

    override fun delete(id: String) {
        val bus = findBusByIdOrThrowNotFound(id)
        busRepository.delete(bus)
    }

    override fun list(listBusRequest: ListBusRequest): List<BusResponse> {
        val page = busRepository.findAll(PageRequest.of(listBusRequest.page, listBusRequest.size))

        val buses: List<Bus> = page.get().collect(Collectors.toList())

        return buses.map { convertBusToBusResponse(it) }
    }

    private fun findBusByIdOrThrowNotFound(id: String): Bus {
        val bus = busRepository.findByIdOrNull(id)
        if (bus == null) {
            throw NotFoundException()
        }else{
            return bus
        }
    }

    private fun convertBusToBusResponse(bus: Bus): BusResponse{
        return BusResponse(
            busId = bus.busId,
            busLicense = bus.busLicense,
            busName = bus.busName,
            busIcon = bus.busIcon,
            busImage = bus.busImage,
            price = bus.price,
            journeyList = bus.journeyList,
            createdAt = bus.createdAt,
            updatedAt = bus.updatedAt
        )
    }
}