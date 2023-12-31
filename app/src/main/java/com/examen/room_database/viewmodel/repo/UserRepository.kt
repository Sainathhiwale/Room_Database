package com.examen.room_database.viewmodel.repo

import com.examen.room_database.data.entity.dao.RoomDao
import com.examen.room_database.data.UserRegister

class UserRepository(private val roomDao: RoomDao) {


    fun insertUser(userRegister: UserRegister){
        roomDao.insertUsers(userRegister)
    }

}