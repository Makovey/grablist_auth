package com.makovey.grablist_auth.repository

import com.makovey.grablist_auth.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepo: CrudRepository<User, Long> {}