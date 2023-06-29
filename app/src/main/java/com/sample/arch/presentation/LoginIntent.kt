package com.sample.arch.presentation

sealed class LoginIntent{

    data class SetEmailText(val text: String): LoginIntent()
    data class SetPasswordText(val text: String): LoginIntent()
}
