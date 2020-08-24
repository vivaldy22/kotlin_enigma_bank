package com.example.enigma_bank.ui.transaction

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.enigma_bank.config.RetrofitBuilder

class TransactionViewModel : ViewModel() {

    private val transactionRepo: TransactionRepository

    init {
        val transactionAPI = RetrofitBuilder.createRetrofit().create(TransactionAPI::class.java)
        transactionRepo = TransactionRepository(transactionAPI)
    }

    val transactions: LiveData<List<Transaction>> = transactionRepo.transactions

    fun getTransactionsByUserOwnerID(id: String) {
        transactionRepo.getTransactionsByUserOwnerID(id)
    }

    fun createTransaction(transaction: Transaction) {
        transactionRepo.createTransaction(transaction)
    }

}