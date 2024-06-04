package neddyap.rutbisapi.repository

import neddyap.rutbisapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String>