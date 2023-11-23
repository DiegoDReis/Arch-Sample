package com.sample.arch.domain.transaction.usecase

import com.sample.arch.domain.transaction.entity.Transaction
import com.sample.arch.domain.transaction.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetTransactions(private val repository: TransactionRepository) {
    operator fun invoke(): Flow<List<Transaction>> = repository.getTransaction()
}