package neddyap.rutbisapi.entity

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "tbl_user")
data class User(

    @Id
    val userId: String = "",

    @Column(name = "userName")
    var userName: String = "",

    @Column(name = "userEmail")
    var userEmail: String = "",

    @Column(name = "userPassword")
    var userPassword: String = "",

    @Column(name = "userAvatar")
    var userAvatar: Int,

    @Column(name = "apiKey")
    var apiKey: String = "",

    @Column(name = "createdAt")
    @Temporal(TemporalType.TIMESTAMP)
    val createdAt: Date = Date(),

    @Column(name = "updatedAt")
    @Temporal(TemporalType.TIMESTAMP)
    var updatedAt: Date? = Date()
)