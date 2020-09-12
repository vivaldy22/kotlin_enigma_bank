package com.example.enigma_bank.ui.login

import com.example.enigma_bank.ui.user.User

class Login (
    var user_email: String = "",
    var user_password: String = "",
)



class LoginResponse(
    var user: User = User(),
    var token: String = ""
)