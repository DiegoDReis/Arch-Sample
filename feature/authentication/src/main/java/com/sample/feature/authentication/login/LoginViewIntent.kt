package com.sample.feature.authentication.login

import com.sample.core.common.presentation.ViewIntent

sealed class LoginViewIntent: ViewIntent {

    data class SetEmailText(val text: String, val isValidEmail: Boolean): LoginViewIntent()
    data class SetPasswordText(val text: String): LoginViewIntent()
}
