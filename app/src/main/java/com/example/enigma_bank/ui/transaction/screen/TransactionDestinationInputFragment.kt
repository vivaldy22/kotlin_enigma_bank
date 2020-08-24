package com.example.enigma_bank.ui.transaction.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_transaction_destination_input.*

class TransactionDestinationInputFragment : Fragment() {

    private val userViewModel by activityViewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_destination_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transaction_next_button.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("destination", transaction_receiver_name.text.toString())

            Navigation.findNavController(view).navigate(
                R.id.action_to_transactionAmountInputFragment,
                bundle
            )
        }
    }

}