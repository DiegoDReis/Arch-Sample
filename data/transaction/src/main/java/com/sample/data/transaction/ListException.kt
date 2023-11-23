package com.sample.data.transaction

data class ListException(
    val throws: List<Exception>
): RuntimeException()

