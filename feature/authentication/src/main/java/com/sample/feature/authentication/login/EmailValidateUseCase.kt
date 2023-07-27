package com.sample.feature.authentication.login

class EmailValidateUseCase {

     operator fun invoke(email: String):Boolean = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}".toRegex().matches(email)

}