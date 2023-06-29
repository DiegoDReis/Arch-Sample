package com.sample.arch.presentation.presentation.login

import com.sample.arch.presentation.core.common.ViewModel

class LoginViewModel :
    ViewModel<LoginViewState, LoginViewIntent>(LoginViewState(), LoginViewReducer()) {

    fun setEmail(email: String) {
        reduce(LoginViewIntent.SetEmailText(email))
    }

    fun setPassword(email: String) {
        reduce(LoginViewIntent.SetPasswordText(email))
    }
}
