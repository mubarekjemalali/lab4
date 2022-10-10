package com.example.lab4

import java.io.Serializable

data class User(var firstName: String, var lastName: String, var username: String, var pwd: String) :
    Serializable
//    var firstName = firstName
//    get() {return firstName}
//    var lastName = lastName
//    get() {return lastName}
//    var username = username
//   // get() {return username}
//    var pwd = pwd
//    get() {return pwd}

