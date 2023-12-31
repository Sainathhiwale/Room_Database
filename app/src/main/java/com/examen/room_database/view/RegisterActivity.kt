package com.examen.room_database.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.examen.room_database.MyApplication
import com.examen.room_database.R
import com.examen.room_database.data.UserRegister
import com.examen.room_database.databinding.ActivityRegisterBinding
import com.examen.room_database.utils.UserViewModelFactory
import com.examen.room_database.viewmodel.UserViewModel
import androidx.activity.viewModels


class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private val TAG: String = "RegisterActivity"
    private lateinit var activityRegisterBinding: ActivityRegisterBinding
    private lateinit var name: String
    private lateinit var email: String
    private lateinit var password: String
    private val userViewModel:UserViewModel by viewModels{
     UserViewModelFactory((application as MyApplication).userRepository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityRegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = activityRegisterBinding.root

        setContentView(view)
        initView()
    }

    private fun initView() {

        // Use ViewModelProvider to get an instance of UserViewModel
        activityRegisterBinding.btRegister.setOnClickListener(this)
        name = activityRegisterBinding.etUserName.text.toString().trim()
        email = activityRegisterBinding.etUserEmail.text.toString().trim()
        password = activityRegisterBinding.etUserPassword.text.toString().trim()

    }

    private fun checkValidtion(): Boolean {
        // Validate name
        /*if (name.isEmpty()) {
            // Handle empty name (show error message, etc.)
            Toast.makeText(this, "name should not empty!", Toast.LENGTH_SHORT).show()

        }
        // Validate email
        if (email.isEmpty()) {
            Toast.makeText(this, "email should not empty!", Toast.LENGTH_SHORT).show()
            // Handle empty email (show error message, etc.)
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // Handle invalid email format
            Toast.makeText(this, "email address is not matched !", Toast.LENGTH_SHORT).show()
        }

        // Validate password
        val MIN_PASSWORD_LENGTH = 8
        if (password.isEmpty()) {
            // Handle empty password (show error message, etc.)
            Toast.makeText(this, "password should not empty!", Toast.LENGTH_SHORT).show()

        } else if (password.length < MIN_PASSWORD_LENGTH) {
            // Handle password length requirement (show error message, etc.)
            Toast.makeText(this, "password length should be 8 character!", Toast.LENGTH_SHORT)
                .show()

        }*/
        return true;

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btRegister -> {
                if (checkValidtion()) {
                    registerUser()
                } else {
                    Toast.makeText(this, "Empty field is not allowed!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun registerUser() {

        val newUser = UserRegister(name,email,password)
        userViewModel.insert(newUser)
        Toast.makeText(this, "inserted succssfully!", Toast.LENGTH_SHORT).show()

    }
}