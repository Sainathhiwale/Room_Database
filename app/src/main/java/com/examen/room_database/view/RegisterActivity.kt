package com.examen.room_database.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.examen.room_database.R
import com.examen.room_database.data.UserRegister
import com.examen.room_database.databinding.ActivityRegisterBinding
import com.examen.room_database.utils.ViewModelFactory
import com.examen.room_database.viewmodel.UserViewModel
import androidx.lifecycle.ViewModelProvider
import com.examen.room_database.data.database.DatabaseBuilder
import com.examen.room_database.data.database.DatabaseHelperImpl


class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var activityRegisterBinding: ActivityRegisterBinding
    private var id:Int =0
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = activityRegisterBinding.root

        setContentView(view)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                DatabaseHelperImpl(DatabaseBuilder.getInstance(applicationContext))
            )
        )[UserViewModel::class.java]
    }

    private fun setupUI() {
        // Use ViewModelProvider to get an instance of UserViewModel
        activityRegisterBinding.btRegister.setOnClickListener(this)

    }




    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btRegister -> {
                loginUser()

            }
        }
    }

    private fun loginUser() {
       id++
        val register = UserRegister(id,activityRegisterBinding.etUserName.text.toString(),activityRegisterBinding.etUserEmail.text.toString(), activityRegisterBinding.etUserPassword.text.toString())
        viewModel.insertLoginUser(register)
    }


}