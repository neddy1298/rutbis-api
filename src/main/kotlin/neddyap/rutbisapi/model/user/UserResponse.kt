package neddyap.rutbisapi.model.user

import java.util.*

data class UserResponse (

        val userId: String,
        val userName: String,
        val userEmail: String,
        val userPassword: String,
        val userAvatar: Int,
        val createdAt: Date,
        val updatedAt: Date?
)