package neddyap.rutbisapi.model.bus

import java.util.*

data class BusResponse (
        
        val busId: String,
        val busLicense: String,
        val busName: String,
        val busIcon: String,
        val busImage: String,
        val price: Long,
        val createdAt: Date,
        val updatedAt: Date?
)