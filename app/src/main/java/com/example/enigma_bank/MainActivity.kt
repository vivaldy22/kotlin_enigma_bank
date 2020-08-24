package com.example.enigma_bank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.enigma_bank.ui.login.LoginViewModel

class MainActivity : AppCompatActivity() {

//    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        loginViewModel.getAllLogin()
    }
}