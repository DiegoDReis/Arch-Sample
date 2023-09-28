package com.sample.data.transaction.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sample.data.transaction.entity.TransactionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = REPLACE)
    fun insertTransaction(vararg transactionEntity: TransactionEntity)

    @Query("select * from `transaction`")
    fun getTransactions(): Flow<List<TransactionEntity>>
}