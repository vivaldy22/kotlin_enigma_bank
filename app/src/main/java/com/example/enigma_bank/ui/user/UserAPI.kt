package com.example.enigma_bank.ui.user

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserAPI {

    @GET("user/{id}")
    fun getUserByID(@Path("id") id: Int): Call<User>

    @PUT("user/{id}")
    fun updateUser(@Path("id") id: Int): Call<User>

}