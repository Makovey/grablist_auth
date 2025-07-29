package com.makovey.grablist_auth.repository

import com.makovey.grablist_auth.entity.Role
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface RoleRepo: CrudRepository<Role, Long> {
    @Transactional(readOnly = true)
    fun findByName(name: String): Role?
}