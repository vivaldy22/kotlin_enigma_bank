package com.example.enigma_bank.domains.login

import retrofit2.Call
import retrofit2.http.GET

interface LoginAPI {

    @GET("logins")
    fun getAllLogin(): Call<List<Login>>

}