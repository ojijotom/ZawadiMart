package com.ojijo.zawadimart.repository

import com.ojijo.zawadimart.data.UserDao
import com.ojijo.zawadimart.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun registerUser(user: User) {
        userDao.registerUser(user)
    }

    suspend fun loginUser(email: String, password: String): User? {
        return userDao.loginUser(email, password)
    }
}