package com.example.logisticlink

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("auth/register")
    fun registerCarrier(
        @Field("FirstName") firstName: String,
        @Field("LastName") lastName: String,
        @Field("Email") email: String,
        @Field("Password") password: String
    ): Call<Any> // Bu response tipini API'ye göre güncellenecek
}