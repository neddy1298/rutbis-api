package neddyap.rutbisapi.entity

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "bus")
data class Bus(
    @Id
    val busId: String = "",

    @Column(name = "busLicense")
    var busLicense: String = "",

    @Column(name = "busName")
    var busName: String = "",

    @Column(name = "busIcon")
    var busIcon: String = "",

    @Column(name = "busImage")
    var busImage: String = "",

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: Date = Date(),

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = Date()
)