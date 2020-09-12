package com.example.enigma_bank.ui.login

class Login (
    var user_email: String = "",
    var user_password: String = "",
)

class User (
    var user_id: String = "",
    var user_email: String = "",
    var user_password: String = "",
    var user_f_name: String = "",
    var user_l_name: String = "",
    var user_gender: String = "",
    var user_balance: String = "",
    var user_level: String = "",
    var user_status: String = "",
)

class LoginResponse(
    var user: User = User(),
    var token: String = ""
)