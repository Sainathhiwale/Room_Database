package com.examen.room_database.data.entity.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.examen.room_database.data.UserRegister

@Dao
interface RoomDao {
    // insert user details
    @Insert()
    suspend fun insertUsers(userRegister: UserRegister)
    // update the user
    @Update()
    fun updateUser(userRegister: UserRegister)
    // delete the user details
    @Delete
    fun deleteUser(userRegister: UserRegister)

    //get all user details
    @Query("SELECT * FROM userregister")
    fun getAllUser():List<UserRegister>

    // get user login details based on id
    @Query("select * from userregister where id=:userId")
    fun getUserById(userId:Int): UserRegister?

    // get registered user details for login
    @Query("SELECT * FROM userregister WHERE email = :emailUser AND password = :passwordUser")
    fun getLoginUserPasswordById(emailUser: String, passwordUser: String):Boolean


}