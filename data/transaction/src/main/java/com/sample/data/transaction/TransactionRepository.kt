package com.sample.data.transaction

import com.sample.data.transaction.datasource.TransactionLocalDataSourceImpl
import com.sample.data.transaction.entity.TransactionEntity


internal class TransactionRepository(
    private val localDataSourceImpl: TransactionLocalDataSourceImpl
) {

    fun getTransaction() = localDataSourceImpl.getTransactions()

    fun insertTransaction(transactionEntity: TransactionEntity) =
        localDataSourceImpl.insertTransaction(transactionEntity)
}