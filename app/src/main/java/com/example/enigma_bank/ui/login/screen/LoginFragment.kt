package com.example.enigma_bank.ui.login.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.login.Login
import com.example.enigma_bank.ui.login.LoginViewModel
import com.example.enigma_bank.ui.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val loginViewModel by activityViewModels<LoginViewModel>()
    private val userViewModel by activityViewModels<UserViewModel>()
    private var users: List<Login> = listOf(Login())
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        loginViewModel.getAllLogin()
        loginViewModel.allLogin.observe(viewLifecycleOwner, Observer {
            users = it
        })

        login_button.setOnClickListener {
            val inputUsername = login_username_input.text.toString()
            val inputPassword = login_password_input.text.toString()

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(activity, "User credentials must be filled!", Toast.LENGTH_SHORT).show()
            } else {
                for (user in users) {
                    if (user.username == inputUsername && user.password == inputPassword) {
                        userViewModel.getUserByID(user.login_id)
                        Toast.makeText(activity, "Welcome ${inputUsername}!", Toast.LENGTH_SHORT).show()
                        navController.navigate(R.id.action_loginFragment_to_transactionActivity)
                    }
                }
            }
        }
    }

}