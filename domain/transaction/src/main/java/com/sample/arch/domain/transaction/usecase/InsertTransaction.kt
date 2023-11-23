package com.sample.arch.domain.transaction.usecase

import com.sample.arch.domain.transaction.entity.Transaction
import com.sample.arch.domain.transaction.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import java.io.IOException

class InsertTransaction(private val repository: TransactionRepository) {
    operator fun invoke(transaction: Transaction): Flow<Unit> = if(transaction.id == null){
        repository.insertTransaction(transaction)
    } else throw IOException()
}