package com.example.enigma_bank.ui.transaction.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.enigma_bank.R
import kotlinx.android.synthetic.main.fragment_transaction_destination_input.*

class TransactionDestinationInputFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_destination_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transaction_next_button.setOnClickListener {
            val userOwnerID = arguments?.getInt("user_owner_id")
            val bundle = Bundle()
            bundle.putInt("user_owner_id", userOwnerID!!)
            bundle.putString("destination", transaction_receiver_name.text.toString())

            Navigation.findNavController(view).navigate(
                R.id.action_transactionDestinationInputFragment_to_transactionAmountInputFragment,
                bundle
            )
        }
    }

}