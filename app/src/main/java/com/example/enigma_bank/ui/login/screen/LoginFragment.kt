package com.example.enigma_bank.ui.login.screen

import android.content.Context
import android.content.SharedPreferences
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
import com.example.enigma_bank.ui.login.LoginResponse
import com.example.enigma_bank.ui.login.LoginViewModel
import com.example.enigma_bank.ui.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    private val loginViewModel by activityViewModels<LoginViewModel>()
    private val userViewModel by activityViewModels<UserViewModel>()
    private var userData: LoginResponse = LoginResponse()
    private lateinit var navController: NavController
    private var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(
            getString(R.string.shared_preferences_name),
            Context.MODE_PRIVATE
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        login_button.setOnClickListener {
            val inputUsername = login_username_input.text.toString()
            val inputPassword = login_password_input.text.toString()

            if (inputUsername.isEmpty() || inputPassword.isEmpty()) {
                Toast.makeText(activity, "User credentials must be filled!", Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel.login(Login(inputUsername, inputPassword))
                loginViewModel.userData.observe(viewLifecycleOwner, {
                    if (it != null) {
                        println("LEVEL ${it.user.user_level}")
                        if (it.user.user_level == "2") {
                            Toast.makeText(activity, "Welcome ${it.user.user_f_name}!", Toast.LENGTH_SHORT).show()
                            navController.navigate(R.id.action_to_userHomeFragment)
                        }
                    } else {
                        Toast.makeText(activity, "Username atau Password salah", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }

}