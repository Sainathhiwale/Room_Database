package com.examen.room_database.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.examen.room_database.data.UserRegister
import com.examen.room_database.data.entity.dao.RoomDao

//main branch is created for take pull of coroutine-flow mvvm branch
@Database(entities = [UserRegister::class], version = 1 )
abstract class AppDatabase:RoomDatabase() {

    abstract fun getRoomDao(): RoomDao

}