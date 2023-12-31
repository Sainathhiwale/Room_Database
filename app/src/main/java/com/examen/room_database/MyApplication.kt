package com.examen.room_database

import android.app.Application
import android.content.Context
import com.examen.room_database.data.database.AppDatabase
import com.examen.room_database.viewmodel.repo.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class MyApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    //Instantiate the repository and the database
// Using by lazy so the database and the repository are only created when they're needed
// rather than when the application starts
    val appDatabase by lazy{AppDatabase.getDatabase(this,applicationScope)}
    val userRepository by lazy { UserRepository(appDatabase.getRoomDao()) }
    override fun onCreate() {
        super.onCreate()
    }


}