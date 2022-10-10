package com.example.lab4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping.*

class Shopping : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        var intent = intent
        var username = intent.getStringExtra("username")
        welcome.text = "Welcome $username"


    }
    fun selection(view: View) {
        var message: String = "message"
        when(view.id){
            R.id.food -> message = "Food"
            R.id.electronics -> message = "Electronics"
            R.id.beauty -> message = "Beauty"
            R.id.clothing -> message = "Clothing"
        }
        Toast.makeText(this, "You have chosen the $message category of shopping", Toast.LENGTH_LONG).show()
    }

}