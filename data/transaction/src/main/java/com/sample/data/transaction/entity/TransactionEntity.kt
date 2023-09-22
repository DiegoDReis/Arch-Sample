package com.sample.data.transaction.entity

import androidx.room.Entity
import java.util.Date

data class TransactionEntity(
    val description: String,
    val price: Float,
    val date: Date
)
