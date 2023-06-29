package com.sample.arch.presentation.presentation.login

import androidx.lifecycle.LiveData
import com.sample.arch.presentation.core.common.ViewReducer

class LoginViewReducer : ViewReducer<LoginViewState, LoginViewIntent> {
    override fun reduce(viewState: LiveData<LoginViewState>, viewIntent: LoginViewIntent): LoginViewState? {
        return when (viewIntent) {
            is LoginViewIntent.SetEmailText -> viewState.value?.copy(emailText = viewIntent.text)
            is LoginViewIntent.SetPasswordText -> viewState.value?.copy(passwordText = viewIntent.text)
        }
    }
}