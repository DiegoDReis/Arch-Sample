package com.sample.arch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.sample.arch.databinding.ActivityLoginBinding
import androidx.activity.viewModels

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observerState()
        setupView()
    }

    private fun setupView() {
        binding.apply {
            emailEditText.doOnTextChanged { text, _, _, _ ->
                loginViewModel.dispatchIntent(LoginIntent.SetEmailText(text.toString()))
            }

            passwordEditText.doOnTextChanged { text, _, _, _ ->
                loginViewModel.dispatchIntent(LoginIntent.SetPasswordText(text.toString()))
            }
        }
    }

    private fun observerState() {
        loginViewModel.state.observe(this) { state ->
            binding.apply {
                state.emailText.takeIf { it != emailEditText.text.toString() }?.let {
                    emailEditText.setText(it)
                }
                state.passwordText.takeIf { it != passwordEditText.text.toString() }?.let {
                    passwordEditText.setText(it)
                }
            }
        }
    }
}