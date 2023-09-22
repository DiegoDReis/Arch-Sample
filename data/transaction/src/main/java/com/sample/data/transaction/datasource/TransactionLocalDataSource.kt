package com.sample.data.transaction.datasource

import com.sample.data.transaction.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

interface TransactionLocalDataSource {
    fun insertTransaction(transactionEntity: TransactionEntity): Flow<Unit>
    fun getTransactions(): Flow<List<TransactionEntity>>
}