package com.example.enigma_bank.ui.login

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginAPI {

    @POST("auth/login")
    fun login(@Body loginData: Login): Call<LoginResponse>

}