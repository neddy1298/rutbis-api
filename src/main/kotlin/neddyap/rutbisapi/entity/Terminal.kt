package neddyap.rutbisapi.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "terminal")
data class Terminal(
    @Id
    val terminalId: String = "",

    @Column(name = "terminalName")
    var terminalName: String = "",

    @Column(name = "terminalLocation")
    var terminalLocation: String = "",

    @Column(name = "teminalIcon")
    var terminalIcon: String = "",

    @Column(name = "terminalImage")
    var terminalImage: String = "",

    @Column(name = "serviceTime")
    var serviceTime: String = "",

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: Date = Date(),

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = Date()
)