package com.example.lab4

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register.setOnClickListener{

            var firstName = firstName.text.toString()
            var lastName = lastName.text.toString()
            var password = password.text.toString()
            var username = username.text.toString()

            var user = User(firstName, lastName, username, password)

            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("newUser", user)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }


}