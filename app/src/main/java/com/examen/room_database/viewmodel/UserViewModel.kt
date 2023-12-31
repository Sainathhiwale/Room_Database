package com.examen.room_database.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examen.room_database.data.UserRegister
import com.examen.room_database.data.database.DatabaseHelper
import com.examen.room_database.utils.UiState
import kotlinx.coroutines.async


class UserViewModel(private val databaseHelper: DatabaseHelper) :ViewModel() {

    private val uiState = MutableLiveData<UiState<List<UserRegister>>>()

    fun insertLoginUser(userRegister: UserRegister){
        viewModelScope.async {
           // uiState.postValue(UiState.Loading)
            try {
              databaseHelper.insertUser(userRegister)
            }catch (ex:Exception){
                uiState.postValue(UiState.Error("Something Went Wrong"))
            }
        }
    }

}