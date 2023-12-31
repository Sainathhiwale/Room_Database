package com.examen.room_database.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserRegister")
data class UserRegister(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "email")
    var email: String?,
    @ColumnInfo(name= "password")
    var password: String
) {
   // constructor() : this(0, "","","")
}
