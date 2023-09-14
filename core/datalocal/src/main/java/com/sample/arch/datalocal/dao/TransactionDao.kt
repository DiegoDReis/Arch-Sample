package com.sample.arch.datalocal.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.sample.arch.datalocal.entity.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertTransaction(vararg transaction: Transaction)

    @Query("select * from `transaction`")
    fun getTransaction(): Flow<List<Transaction>>
}