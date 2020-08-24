package com.example.enigma_bank.ui.transaction.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.enigma_bank.R
import com.example.enigma_bank.ui.transaction.Transaction
import com.example.enigma_bank.ui.transaction.TransactionRecycleAdapter
import com.example.enigma_bank.ui.transaction.TransactionViewModel
import kotlinx.android.synthetic.main.fragment_transaction_history.*

class TransactionHistoryFragment : Fragment() {

    private val transactionViewModel by activityViewModels<TransactionViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transaction_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transaction_recycler_view.layoutManager = LinearLayoutManager(activity)

        transactionViewModel.transactions.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                transaction_recycler_view.adapter = TransactionRecycleAdapter(it)
            } else {
                transaction_recycler_view.adapter = TransactionRecycleAdapter(listOf(Transaction()))
            }
        })
    }

}