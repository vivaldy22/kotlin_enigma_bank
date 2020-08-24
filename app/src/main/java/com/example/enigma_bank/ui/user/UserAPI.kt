package com.example.enigma_bank.ui.user

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UserAPI {

    @GET("user/{id}")
    fun getUserByID(@Path("id") id: String): Call<User>

}