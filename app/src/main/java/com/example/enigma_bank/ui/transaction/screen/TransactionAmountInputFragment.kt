package com.example.enigma_bank.ui.transaction.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.transaction.Transaction
import com.example.enigma_bank.ui.transaction.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_transaction_amount_input.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TransactionAmountInputFragment : Fragment() {

    private val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_amount_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transaction_next_button2.setOnClickListener {
            val userOwnerID = arguments?.getInt("user_owner_id")
            val destination = arguments?.getString("destination")
            val amount = transaction_amount.text
            val description = transaction_description.text

            if (amount!!.isEmpty() || description!!.isEmpty()) {
                Toast.makeText(
                    activity,
                    "Amount and description must be filled!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                val formatted = current.format(formatter)
                println(userOwnerID)
                println(destination)
                println(amount)
                println(description)
                println(formatted)

                transactionViewModel.createTransaction(
                    Transaction(
                        user_owner_id = userOwnerID!!,
                        trans_date = formatted,
                        destination = destination!!,
                        amount = amount.toString().toInt(),
                        description = description.toString()
                    )
                )

                Navigation.findNavController(view)
                    .navigate(R.id.action_transactionAmountInputFragment_to_userHomeFragment)
            }
        }
    }

}