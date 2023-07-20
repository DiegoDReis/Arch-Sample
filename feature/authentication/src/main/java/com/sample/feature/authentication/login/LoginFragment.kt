package com.sample.feature.authentication.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.feature.authentication.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginBinding.inflate(inflater)
        observerState()
        setupView()
        return binding.root
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