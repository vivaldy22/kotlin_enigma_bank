package com.example.enigma_bank.ui.login

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository(private val loginAPI: LoginAPI) {

    val allLogin: MutableLiveData<List<Login>> = MutableLiveData<List<Login>>()

    fun getAllLogin() {
        loginAPI.getAllLogin().enqueue(object : Callback<List<Login>> {
            override fun onResponse(call: Call<List<Login>>, response: Response<List<Login>>) {
                allLogin.value = response.body()
            }

            override fun onFailure(call: Call<List<Login>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}