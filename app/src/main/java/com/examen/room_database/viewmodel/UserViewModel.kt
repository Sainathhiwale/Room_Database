package com.examen.room_database.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examen.room_database.data.UserRegister
import com.examen.room_database.viewmodel.repo.UserRepository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository) :ViewModel() {

    fun insert(userRegister: UserRegister) = viewModelScope.async {
        userRepository.insertUser(userRegister)
    }
}