package com.sample.arch.presentation.presentation.login

import com.sample.arch.presentation.core.common.ViewState

data class LoginViewState(
    val emailText: String = "",
    val passwordText: String = ""
) : ViewState
