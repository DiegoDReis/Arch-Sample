package com.sample.data.transaction.datasource

import android.accounts.NetworkErrorException
import com.sample.data.transaction.ListException
import com.sample.data.transaction.dao.TransactionDao
import com.sample.data.transaction.entity.TransactionEntity
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException
import java.util.Date

internal class TransactionLocalDataSourceTest() {

    private lateinit var dataSource: TransactionLocalDataSource
    private val transactionDao: TransactionDao = mockk()

    @Before
    fun setup() {
        MockKAnnotations.init()
        dataSource = TransactionLocalDataSourceImpl(transactionDao)
    }

    @Test
    fun `When insertTransaction should return a Flow of Unit`() = runBlocking {
        // Given
        val transaction = TransactionEntity(
            id = 1,
            description = "description",
            price = 2.5F,
            date = Date()
        )
        every { transactionDao.insertTransaction(any()) } returns Unit

        // When
        val result = dataSource.insertTransaction(transaction).first()


        // Then
        Assert.assertEquals(result, Unit)
        verify(exactly = 1) { transactionDao.insertTransaction(any()) }
    }

    @Test(expected = IOException::class)
    fun `When insertTransaction should return a throw`() = runBlocking {
        // Given
        val transaction = TransactionEntity(
            id = 1,
            description = "description",
            price = 2.5F,
            date = Date()
        )
        every { transactionDao.insertTransaction(any()) } throws IOException()

        // When
        dataSource.insertTransaction(transaction).first()
    }

    @Test
    fun `When getTransactions should return a Flow with a list of transactions`() = runBlocking {
        // GIVEN
        val transaction1 = TransactionEntity(
            id = 1,
            description = "description",
            price = 2.5F,
            date = Date()
        )
        val transaction2 = TransactionEntity(
            id = 2,
            description = "description",
            price = 2.5F,
            date = Date()
        )
        val transactions = listOf(transaction1, transaction2)
        every { transactionDao.getTransactions() } returns flowOf(transactions)

        // WHEN
        val result = dataSource.getTransactions().first()

        // THEN
        Assert.assertEquals(result, transactions)
        verify(exactly = 1) { transactionDao.getTransactions() }
    }

    @Test
    fun `When getTransactions should return a throw`() {
        // Give
        val exception = ListException(
            listOf(IOException(), NetworkErrorException())
        )
        // When
        every { transactionDao.getTransactions() } throws exception
        val result = Assert.assertThrows(ListException::class.java) { dataSource.getTransactions() }
        // Then
        Assert.assertEquals(result, exception)
    }
}