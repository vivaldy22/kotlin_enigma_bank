package com.example.enigma_bank.ui.user

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository(private val userAPI: UserAPI) {

    val user: MutableLiveData<User> = MutableLiveData<User>()

    fun getUserByID(id: String) {
        userAPI.getUserByID(id).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                user.value = response.body()
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }

        })
    }

}