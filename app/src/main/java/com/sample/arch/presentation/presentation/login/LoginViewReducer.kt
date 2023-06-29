package com.sample.arch.presentation.presentation.login

import com.sample.arch.presentation.core.common.ViewReducer

class LoginViewReducer : ViewReducer<LoginViewState, LoginViewIntent> {
    override fun reduce(viewState: LoginViewState?, viewIntent: LoginViewIntent): LoginViewState? {
        return when (viewIntent) {
            is LoginViewIntent.SetEmailText -> viewState?.copy(emailText = viewIntent.text)
            is LoginViewIntent.SetPasswordText -> viewState?.copy(passwordText = viewIntent.text)
        }
    }
}