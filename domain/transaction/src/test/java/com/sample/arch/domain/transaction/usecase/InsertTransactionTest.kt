package com.sample.arch.domain.transaction.usecase

import com.sample.arch.domain.transaction.entity.Transaction
import com.sample.arch.domain.transaction.repository.TransactionRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class InsertTransactionTest {

    private val repository: TransactionRepository = mockk()
    private lateinit var insertTransactionUseCase: InsertTransaction

    @Before
    fun setUp() {
        insertTransactionUseCase = InsertTransaction(repository)
    }


    @Test
    fun `When call insertTransactionUseCase should insertTransaction with success`() = runBlocking {
        // Given
        every { repository.insertTransaction(any()) } returns flowOf(Unit)
        val transaction = Transaction(
            id = null,
            description = "description",
            price = 2.9F,
            date = null
        )

        // When
        val result = insertTransactionUseCase(transaction)

        // Then
        verify(exactly = 1) { repository.insertTransaction(any()) }
        Assert.assertEquals(result.first()::class.java, Unit::class.java)
    }

    @Test(expected = IOException::class)
    fun `When call insertTransactionUseCase should insertTransaction with exception`() {
        // Given
        every { repository.insertTransaction(any()) } returns flowOf(Unit)
        val transaction = Transaction(
            id = 1,
            description = "description",
            price = 2.9F,
            date = null
        )

        // When
        insertTransactionUseCase(transaction)
    }
}