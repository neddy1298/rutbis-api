package neddyap.rutbisapi.entity

import jakarta.persistence.*

@Entity
@Table(name = "bus_terminal")
data class BusTerminal(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "terminal_id")
    val terminal: Terminal,

    @ManyToOne
    @JoinColumn(name = "bus_id")
    val bus: Bus
)