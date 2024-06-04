package neddyap.rutbisapi.model

import neddyap.rutbisapi.entity.Terminal
import java.util.*

data class BusResponse (
        
        val busId: String,
        val busLicense: String,
        val busName: String,
        val busIcon: String,
        val busImage: String,
        val price: Long,
        val journeyList: List<Terminal>,
        val createdAt: Date,
        val updatedAt: Date?
)