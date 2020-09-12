package com.example.enigma_bank.ui.login

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private val loginAPI: LoginAPI) {

    val userData: MutableLiveData<LoginResponse> = MutableLiveData<LoginResponse>()

    fun login(loginData: Login) {
        loginAPI.login(loginData).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                userData.value = response.body()
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun logout() {
        userData.value = null
    }

}