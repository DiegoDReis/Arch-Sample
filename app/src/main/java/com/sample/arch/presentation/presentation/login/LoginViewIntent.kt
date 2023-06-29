package com.sample.arch.presentation.presentation.login

import com.sample.arch.presentation.core.common.ViewIntent

sealed class LoginViewIntent: ViewIntent {

    data class SetEmailText(val text: String): LoginViewIntent()
    data class SetPasswordText(val text: String): LoginViewIntent()
}
