package com.sample.arch.presentation.presentation.login

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.sample.arch.databinding.ActivityLoginBinding

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
                loginViewModel.setEmail(text.toString())
            }

            passwordEditText.doOnTextChanged { text, _, _, _ ->
                loginViewModel.setPassword(text.toString())
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