package com.example.enigma_bank.ui.transaction

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enigma_bank.R

class TransactionRecycleAdapter(private val listTransaction: List<Transaction>) : RecyclerView.Adapter<TransactionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_transaction, parent, false)
        return TransactionViewHolder(view)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.date.text = listTransaction[position].trans_date
        holder.amount.text = listTransaction[position].amount.toString()
    }

    override fun getItemCount(): Int {
        return listTransaction.size
    }

}

class TransactionViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    val date: TextView = v.findViewById(R.id.transaction_item_date)
    val amount: TextView = v.findViewById(R.id.transaction_item_amount)

}