package com.example.enigma_bank.ui.transaction

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TransactionRepository(private val transactionAPI: TransactionAPI) {

    val transactions: MutableLiveData<List<Transaction>> = MutableLiveData<List<Transaction>>()

    fun getTransactionsByUserOwnerID(id: String) {
        transactionAPI.getTransactionsByUserOwnerID(id).enqueue(object : Callback<List<Transaction>> {
            override fun onResponse(
                call: Call<List<Transaction>>,
                response: Response<List<Transaction>>
            ) {
                transactions.value = response.body()
            }

            override fun onFailure(call: Call<List<Transaction>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    fun createTransaction(transaction: Transaction) {
        transactionAPI.createTransaction(transaction).enqueue(object : Callback<Transaction> {
            override fun onResponse(call: Call<Transaction>, response: Response<Transaction>) {
                println("Transaction created")
            }

            override fun onFailure(call: Call<Transaction>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}