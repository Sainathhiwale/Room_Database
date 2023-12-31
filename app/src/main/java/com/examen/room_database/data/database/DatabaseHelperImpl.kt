package com.examen.room_database.data.database

import com.examen.room_database.data.UserRegister

// implement the databasehelper interface api in this class and pass appdatabase instance
class DatabaseHelperImpl(private val appDatabase: AppDatabase): DatabaseHelper{

    override suspend fun insertUser(userRegister: UserRegister) =
        appDatabase.getRoomDao().insertUsers(userRegister)

}