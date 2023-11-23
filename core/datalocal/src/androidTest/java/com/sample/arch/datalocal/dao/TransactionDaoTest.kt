package com.sample.arch.datalocal.dao

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sample.arch.datalocal.database.AppDatabase
import com.sample.data.transaction.dao.TransactionDao
import com.sample.data.transaction.entity.TransactionEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.Date

@RunWith(AndroidJUnit4::class)
internal class TransactionDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var dao: TransactionDao

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.transactionDao()
    }

    @After
    fun onComplete() {
        database.close()
    }

    @Test
    fun whenInsertTransactionShouldUpdateTheTransactionTable() = runBlocking{
        // GIVEN
        val transaction = TransactionEntity(
            id = 1,
            description = "description",
            price = 2.5F,
            date = Date()
        )

        // WHEN
        dao.insertTransaction(transaction)

        // THEN
        val result = dao.getTransactions().first()
        Assert.assertEquals(result, listOf(transaction))
    }


    @Test
    fun whenInsertAListOfTransactionShouldUpdateTheTransactionTable() = runBlocking{
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

        transactions.forEach { dao.insertTransaction(it) }

        // WHEN
        val result = dao.getTransactions().first()


        // THEN
        Assert.assertEquals(result, transactions)
    }
}