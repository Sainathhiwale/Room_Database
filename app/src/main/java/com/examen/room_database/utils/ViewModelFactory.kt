package com.examen.room_database.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.examen.room_database.data.database.DatabaseHelper
import com.examen.room_database.viewmodel.UserViewModel

class ViewModelFactory(private val databasehelper: DatabaseHelper):
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(databasehelper) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}