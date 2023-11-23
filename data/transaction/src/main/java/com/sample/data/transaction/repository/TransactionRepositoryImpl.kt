package com.sample.data.transaction.repository

import com.sample.arch.domain.transaction.entity.Transaction
import com.sample.arch.domain.transaction.repository.TransactionRepository
import com.sample.data.transaction.datasource.TransactionLocalDataSourceImpl
import com.sample.data.transaction.mapper.mapToTransaction
import com.sample.data.transaction.mapper.mapToTransactionEntity
import kotlinx.coroutines.flow.map


internal class TransactionRepositoryImpl(
    private val localDataSourceImpl: TransactionLocalDataSourceImpl
) : TransactionRepository {

    override fun getTransaction() = localDataSourceImpl.getTransactions().map {
        it.mapToTransaction()
    }

    override fun insertTransaction(transaction: Transaction) =
        localDataSourceImpl.insertTransaction(transaction.mapToTransactionEntity())
}