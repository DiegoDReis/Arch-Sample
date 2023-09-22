package com.sample.arch.datalocal.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sample.arch.datalocal.converter.DateConverter
import com.sample.data.transaction.dao.TransactionDao
import com.sample.data.transaction.entity.TransactionEntity

const val DATABASE_NAME = "finance.db"

@Database(
    entities = [
       TransactionEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        fun provideDatabase(application: Application) =
            Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}