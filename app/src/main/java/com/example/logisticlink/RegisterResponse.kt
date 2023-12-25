package com.example.logisticlink

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String
)
