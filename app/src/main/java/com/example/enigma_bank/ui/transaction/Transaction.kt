package com.example.enigma_bank.ui.transaction

class Transaction(
    var trans_id: Int = 0,
    var user_owner_id: Int = 0,
    var trans_date: String = "",
    var destination: String = "",
    var amount: Int = 0,
    var description: String = ""
)