package com.sample.feature.authentication.login

import com.sample.core.common.presentation.ViewState

data class LoginViewState(
    val emailText: String = "",
    val passwordText: String = ""
) : ViewState
