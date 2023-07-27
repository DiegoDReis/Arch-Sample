package com.sample.feature.authentication.login

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.sample.feature.authentication.AuthStub.EMAIL
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class LoginViewModelTest{


    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: LoginViewModel
    private val validateEmail: EmailValidateUseCase = mockk()

    @Before
    fun setup(){
        viewModel = LoginViewModel(validateEmail)
    }

    @Test
    fun `setEmail SHOULD return the input email text`() {
        // GIVEN
        every { validateEmail(any()) } returns false

        // WHEN
        viewModel.setEmail(EMAIL)

        // THEN
        verify(exactly = 1) { validateEmail(any()) }
        Assert.assertEquals(EMAIL, viewModel.state.value?.emailText)
        Assert.assertEquals(true, viewModel.state.value?.emailError)
    }

}