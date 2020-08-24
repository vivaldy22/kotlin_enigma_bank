package com.example.enigma_bank.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigma_bank.config.RetrofitBuilder

class LoginViewModel : ViewModel() {

    private val loginRepo: LoginRepository

    init {
        val loginAPI = RetrofitBuilder.createRetrofit().create(LoginAPI::class.java)
        loginRepo = LoginRepository(loginAPI)
    }

    val allLogin: LiveData<List<Login>> = loginRepo.allLogin

    fun getAllLogin() {
        loginRepo.getAllLogin()
    }

}