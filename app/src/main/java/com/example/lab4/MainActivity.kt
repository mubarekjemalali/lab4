package com.example.lab4

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main  )

        var resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
            if(result.resultCode == Activity.RESULT_OK){
                users.add(result.data?.getSerializableExtra("newUser") as User)
            }

            else
                Toast.makeText(this, "Failed to get Result", Toast.LENGTH_LONG).show()

        }

        createAcntbtn.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            resultContracts.launch(intent)
        }

    }

    var u1 = User("Mubarek", "Ali", "mubithelong", "123")
    var u2 = User("iqra", "Jemal", "iqra","qwe")
    var u3 = User("Mahir", "Kuru", "mahir","123")
    var u4 = User("Rida", "Kuru", "rida","123")
    var u5 = User("Yusra", "Temam", "yusra","123")
    var users =  arrayListOf<User>(u1, u2, u3, u4, u5)

    fun signIn(view: View){
        var username = username.text.toString()
        var password = pass.text.toString()
        val intent = Intent(this, Shopping::class.java)

        for (user in users){

            if(user.username == username){
                // render another layout
                intent.putExtra("username", username)
                startActivity(intent)
                break
            }
        }

        // show a message that the user doesn't exist


    }



    fun forgetPassword(view: View) {
        var username = username.text.toString()
        var password = ""

        for(user in users){
            if(user.username == username)
                password = user.pwd
        }
        if(password.isNotEmpty()){
            val intent = Intent(
                Intent.ACTION_SENDTO, Uri.parse("mailto:$username?&subject=Forgot Password&body=$password"
                )
            )
            startActivity(intent)
        }



    }


}