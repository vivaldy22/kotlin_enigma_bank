package com.example.enigma_bank.ui.user.screen

import android.content.Intent
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
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.login.LoginViewModel
import com.example.enigma_bank.ui.transaction.TransactionViewModel
import com.example.enigma_bank.ui.user.User
import com.example.enigma_bank.ui.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_user_home.*

class UserHomeFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels<LoginViewModel>()
    private val userViewModel by activityViewModels<UserViewModel>()
    private val transactionViewModel by activityViewModels<TransactionViewModel>()
    private var user: User = User()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userViewModel.user.observe(viewLifecycleOwner, Observer {
            val bal = "$ ${it.balance}"
            home_user_balance.text = bal
            user = it
        })

        transfer_button.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putInt("user_owner_id", user.login_owner_id)
//
//            Navigation.findNavController(view).navigate(R.id.action_to_transactionDestinationInputFragment, bundle)
            loginViewModel.logout()
            Navigation.findNavController(view).navigate(R.id.action_to_loginFragment)

        }

        history_button.setOnClickListener {
            transactionViewModel.getTransactionsByUserOwnerID(user.login_owner_id.toString())
            Navigation.findNavController(view).navigate(R.id.action_to_transactionHistoryFragment)
        }

        phone_button.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:911")
            startActivity(intent)
        }
    }

}