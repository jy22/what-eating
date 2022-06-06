package com.example.whateating.domain.auth.repository.read

import com.example.whateating.domain.auth.entity.User
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AuthRepository : CoroutineCrudRepository<User, Long>
