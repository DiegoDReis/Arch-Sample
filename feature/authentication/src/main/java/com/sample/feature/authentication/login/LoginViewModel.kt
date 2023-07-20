package com.sample.feature.authentication.login

import com.sample.core.common.presentation.ViewModel

class LoginViewModel :
    ViewModel<LoginViewState, LoginViewIntent>(LoginViewState(), LoginViewReducer()) {

    fun setEmail(email: String) {
        reduce(LoginViewIntent.SetEmailText(email))
    }

    fun setPassword(email: String) {
        reduce(LoginViewIntent.SetPasswordText(email))
    }
}
