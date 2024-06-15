package neddyap.rutbisapi.service.impl

import neddyap.rutbisapi.error.NotFoundException
import neddyap.rutbisapi.entity.User
import neddyap.rutbisapi.model.user.CreateUserRequest
import neddyap.rutbisapi.model.user.ListUserRequest
import neddyap.rutbisapi.model.user.UpdateUserRequest
import neddyap.rutbisapi.model.user.UserResponse
import neddyap.rutbisapi.repository.UserRepository
import neddyap.rutbisapi.service.UserService
import neddyap.rutbisapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.Date
import java.util.stream.Collectors

@Service
class UserServiceImpl(
    val userRepository: UserRepository,
    val validationUtil: ValidationUtil
): UserService {
    override fun create(createUserRequest: CreateUserRequest): UserResponse {

        validationUtil.validate(createUserRequest)

        val user = User(
            userId = createUserRequest.userId,
            userName = createUserRequest.userName!!,
            userEmail = createUserRequest.userEmail!!,
            userPassword = createUserRequest.userPassword!!,
            userAvatar = createUserRequest.userAvatar!!,
            createdAt = Date(),
            updatedAt = null
        )

        userRepository.save(user)

        return convertUserToUserResponse(user)
    }

    override fun get(id: String): UserResponse {
        val user = findUserByIdOrThrowNotFound(id)

        return convertUserToUserResponse(user)

    }

    override fun update(id: String, updateUserRequest: UpdateUserRequest): UserResponse {
        val user = findUserByIdOrThrowNotFound(id)

        validationUtil.validate(updateUserRequest)

        user.apply {
            userName = updateUserRequest.userName!!
            userEmail = updateUserRequest.userEmail!!
            userPassword = updateUserRequest.userPassword!!
            userAvatar = updateUserRequest.userAvatar!!
            updatedAt = Date()
        }

        userRepository.save(user)

        return convertUserToUserResponse(user)
    }

    override fun delete(id: String) {
        val user = findUserByIdOrThrowNotFound(id)
        userRepository.delete(user)
    }

    override fun list(listUserRequest: ListUserRequest): List<UserResponse> {
        val page = userRepository.findAll(PageRequest.of(listUserRequest.page, listUserRequest.size))

        val users: List<User> = page.get().collect(Collectors.toList())

        return users.map { convertUserToUserResponse(it) }
    }

    private fun findUserByIdOrThrowNotFound(id: String): User {
        val user = userRepository.findByIdOrNull(id)
        if (user == null) {
            throw NotFoundException()
        }else{
            return user
        }
    }

    private fun convertUserToUserResponse(user: User): UserResponse {
        return UserResponse(
            userId = user.userId,
            userName = user.userName,
            userEmail = user.userEmail,
            userPassword = user.userPassword,
            userAvatar = user.userAvatar,
            createdAt = Date(),
            updatedAt = null
        )
    }
}