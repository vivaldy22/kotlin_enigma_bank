package com.example.enigma_bank.ui.transaction.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.enigma_bank.R
import kotlinx.android.synthetic.main.fragment_transaction_success.*

class TransactionSuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transaction_done_button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_to_userHomeFragment)
        }
    }

}