package com.sample.data.transaction.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "transaction")
data class TransactionEntity(
    @PrimaryKey
    val id: Int,
    val description: String,
    val price: Float,
    val date: Date
)
