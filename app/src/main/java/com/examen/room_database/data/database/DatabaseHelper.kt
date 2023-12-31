package com.examen.room_database.data.database

import com.examen.room_database.data.UserRegister

// update the db throw this class with api method.
interface DatabaseHelper {

    suspend fun insertUser(userRegister: UserRegister)

}