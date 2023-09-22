package com.sample.data.transaction.datasource

import com.sample.data.transaction.dao.TransactionDao
import com.sample.data.transaction.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class TransactionLocalDataSourceImpl(
    private val dao: TransactionDao
) : TransactionLocalDataSource {


    override fun insertTransaction(transactionEntity: TransactionEntity) = flow {
        emit(dao.insertTransaction(transactionEntity))
    }

    override fun getTransactions(): Flow<List<TransactionEntity>> = dao.getTransactions()
}