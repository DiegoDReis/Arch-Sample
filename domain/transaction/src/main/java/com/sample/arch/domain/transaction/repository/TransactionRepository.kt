package com.sample.arch.domain.transaction.repository

import com.sample.arch.domain.transaction.entity.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {
    fun getTransaction(): Flow<List<Transaction>>
    fun insertTransaction(transaction: Transaction): Flow<Unit>
}