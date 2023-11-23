package com.sample.data.transaction.mapper

import com.sample.arch.domain.transaction.entity.Transaction
import com.sample.data.transaction.entity.TransactionEntity
import java.util.Date

fun Transaction.mapToTransactionEntity() = TransactionEntity(
    description = this.description,
    price = this.price,
    date = Date()
)

private fun TransactionEntity.mapToTransaction() = Transaction(
    id = this.id,
    description = this.description,
    price = this.price,
    date = this.date
)

fun List<TransactionEntity>.mapToTransaction(): List<Transaction> = this.map {
    it.mapToTransaction()
}