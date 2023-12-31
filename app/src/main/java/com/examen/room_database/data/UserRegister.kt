package com.examen.room_database.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserRegister")
data class UserRegister(
    @PrimaryKey var id: Int,
    var  name: String, var email: String, var password: String
) {
    constructor( name: String, email: String,  password: String):this(0,name,email,password)
}
