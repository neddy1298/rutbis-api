package neddyap.rutbisapi.service

import neddyap.rutbisapi.model.user.CreateUserRequest
import neddyap.rutbisapi.model.user.ListUserRequest
import neddyap.rutbisapi.model.user.UserResponse
import neddyap.rutbisapi.model.user.UpdateUserRequest

interface UserService {

    fun create(createUserRequest: CreateUserRequest): UserResponse

    fun get(id: String): UserResponse

    fun update(id: String, updateUserRequest: UpdateUserRequest): UserResponse

    fun delete(id: String)

    fun list(listUserRequest: ListUserRequest): List<UserResponse>
}