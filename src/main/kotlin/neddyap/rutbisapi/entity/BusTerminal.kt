package neddyap.rutbisapi.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "bus_terminal")
data class BusTerminal(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "terminal_id")
    val terminalId: Terminal,

    @ManyToOne
    @JoinColumn(name = "bus_id")
    val busId: Bus,

    @Column(name = "price")
    var price: Long,

    @Column(name = "departure_time")
    var departureTime: Date,

    @Column(name = "arrival_time")
    var arrivalTime: Date,

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: Date = Date(),

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = Date()

)