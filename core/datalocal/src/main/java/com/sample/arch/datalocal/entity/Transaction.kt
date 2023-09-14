package com.sample.arch.datalocal.entity

import androidx.room.Entity
import java.util.Date

@Entity(tableName = "transaction")
data class Transaction(
    val description: String,
    val price: Float,
    val date: Date
)
