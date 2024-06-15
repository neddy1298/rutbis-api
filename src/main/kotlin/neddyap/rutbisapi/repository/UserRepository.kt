package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String>