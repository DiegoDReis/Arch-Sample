package com.sample.arch.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _state: MutableLiveData<LoginViewState> = MutableLiveData(LoginViewState())
    val state: LiveData<LoginViewState> = _state

    fun dispatchIntent(intent: LoginIntent) {
        when (intent) {
            is LoginIntent.SetEmailText -> _state.value = _state.value?.copy(emailText = intent.text)
            is LoginIntent.SetPasswordText -> _state.value =
                _state.value?.copy(passwordText = intent.text)
        }
    }
}