package com.example.enigma_bank.ui.transaction.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.transaction.Transaction
import com.example.enigma_bank.ui.transaction.TransactionViewModel
import com.example.enigma_bank.ui.user.UserViewModel
import kotlinx.android.synthetic.main.fragment_transaction_amount_input.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class TransactionAmountInputFragment : Fragment() {

    private val userViewModel by activityViewModels<UserViewModel>()
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
//            val userOwnerID = arguments?.getInt("user_owner_id")
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
                userViewModel.user.observe(viewLifecycleOwner, Observer {
                    if (userViewModel.user.value!!.balance >= amount.toString().toInt()) {
                        val current = LocalDateTime.now()
                        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                        val formatted = current.format(formatter)

                        transactionViewModel.createTransaction(
                            Transaction(
                                user_owner_id = it.user_id,
                                trans_date = formatted,
                                destination = destination!!,
                                amount = amount.toString().toInt(),
                                description = description.toString()
                            )
                        )

                        it.balance -= amount.toString().toInt()

                        Navigation.findNavController(view)
                            .navigate(R.id.action_to_transactionSuccessFragment)
                    } else {
                        Toast.makeText(activity, "Not enough balance on your account!", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(view)
                            .navigate(R.id.action_to_userHomeFragment)
                    }
                })
            }
        }
    }

}