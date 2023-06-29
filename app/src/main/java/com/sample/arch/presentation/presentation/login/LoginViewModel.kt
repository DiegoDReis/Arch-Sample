package com.sample.arch.presentation.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sample.arch.presentation.core.common.MVIViewModel

class LoginViewModel :
    MVIViewModel<LoginViewState, LoginViewIntent>(LoginViewState(), LoginViewReducer()) {

    fun setEmail(email: String) {
        reduce(LoginViewIntent.SetEmailText(email))
    }

    fun setPassword(email: String) {
        reduce(LoginViewIntent.SetPasswordText(email))
    }
}