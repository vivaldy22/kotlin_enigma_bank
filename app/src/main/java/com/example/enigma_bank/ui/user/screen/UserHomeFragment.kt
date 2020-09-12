package com.example.enigma_bank.ui.user.screen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.login.LoginViewModel
import com.example.enigma_bank.ui.transaction.TransactionViewModel
import com.example.enigma_bank.ui.user.User
import com.example.enigma_bank.ui.user.UserViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user_home.*

class UserHomeFragment : Fragment() {

    private var sharedPreferences: SharedPreferences? = null
    private val loginViewModel: LoginViewModel by activityViewModels<LoginViewModel>()
    private val userViewModel by activityViewModels<UserViewModel>()
    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    private var user: User = User()

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
        return inflater.inflate(R.layout.fragment_user_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = sharedPreferences?.getString(getString(R.string.user_id), "")
        val token = sharedPreferences?.getString(getString(R.string.auth_token), "")
        if (id != null && token != null) {
            println("TOKENN $token")
            userViewModel.getUserByID(token, id)
            userViewModel.user.observe(viewLifecycleOwner, {
                val bal = "$ ${it.user_balance}"
                home_user_balance.text = bal
                user = it
                Picasso.get().load("${getString(R.string.image_link)}$id.jpg").into(user_photo)
            })
        } else {
            view.findNavController().navigate(R.id.action_to_loginFragment)
        }

        if (!sharedPreferences!!.contains(getString(R.string.auth_token))) {
            view.findNavController().navigate(R.id.action_to_loginFragment)
        }

        transfer_button.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putInt("user_owner_id", user.login_owner_id)
//
//            Navigation.findNavController(view).navigate(R.id.action_to_transactionDestinationInputFragment, bundle)
            with(sharedPreferences?.edit()) {
                this?.remove(getString(R.string.auth_token))
                loginViewModel.logout()
                Navigation.findNavController(view).navigate(R.id.action_to_loginFragment)
                this?.apply()
            }
        }

        history_button.setOnClickListener {
//            transactionViewModel.getTransactionsByUserOwnerID(user.login_owner_id.toString())
            Navigation.findNavController(view).navigate(R.id.action_to_transactionHistoryFragment)
        }

        phone_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911")
            startActivity(intent)
        }
    }

}