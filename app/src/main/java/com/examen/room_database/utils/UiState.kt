package com.examen.room_database.utils

sealed interface UiState<out T>{
    data class Success<T>(val data: T) : UiState<T>

    data class Error(val message: String) : UiState<Nothing>

    object Loading : UiState<Nothing>
}