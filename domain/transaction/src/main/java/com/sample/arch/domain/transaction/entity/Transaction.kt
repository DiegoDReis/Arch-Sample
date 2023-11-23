package com.sample.arch.domain.transaction.entity

import java.util.Date

data class Transaction(
    val id: Int?,
    val description: String,
    val price: Float,
    val date: Date
)
