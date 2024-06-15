package neddyap.rutbisapi.controller

import neddyap.rutbisapi.model.*
import neddyap.rutbisapi.model.user.CreateUserRequest
import neddyap.rutbisapi.model.user.ListUserRequest
import neddyap.rutbisapi.model.user.UpdateUserRequest
import neddyap.rutbisapi.model.user.UserResponse
import neddyap.rutbisapi.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
class UserController(val userService: UserService) {

    @PostMapping(
        value = ["/api/user"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createUser(@RequestBody body: CreateUserRequest): WebResponse<UserResponse> {
        val userResponse = userService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = userResponse
        )
    }

    @GetMapping(
        value = ["/api/user/{userId}"],
        produces = ["application/json"]
    )
    fun getUser(@PathVariable("userId") id: String): WebResponse<UserResponse>{
        val userResponse = userService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = userResponse
        )
    }

    @PutMapping(
        value = ["/api/user/{userId}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateUser(@PathVariable("userId") id: String, @RequestBody updateUserRequest: UpdateUserRequest): WebResponse<UserResponse>{
        val userResponse = userService.update(id, updateUserRequest)
        return WebResponse(
            code = 200,
            status = "OK",
            data = userResponse
        )
    }

    @DeleteMapping(
        value = ["/api/user/{userId}"],
        produces = ["application/json"]
    )
    fun deleteUser(@PathVariable("userId") id: String): WebResponse<String>{
        userService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/users"],
        produces = ["application/json"]
    )
    fun listUser(@RequestParam(value = "size", defaultValue = "10") size: Int,
                    @RequestParam(value = "page", defaultValue = "0")page: Int): WebResponse<List<UserResponse>>{
        val request = ListUserRequest(page = page, size = size)
        val responses = userService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }

}