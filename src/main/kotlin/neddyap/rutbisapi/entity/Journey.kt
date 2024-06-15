package neddyap.rutbisapi.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "tbl_journey")
data class Journey(

    @Id
    val journeyId: String = "",

    @ManyToOne
    @JoinColumn(name = "terminal_id")
    var terminalId: Terminal,

    @ManyToOne
    @JoinColumn(name = "bus_id")
    var busId: Bus,

    @Column(name = "price")
    var price: Long,

    @Column(name = "departure_time")
    var departureTime: Date,

    @Column(name = "arrival_time")
    var arrivalTime: Date,

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: Date = Date(),

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = Date()

)