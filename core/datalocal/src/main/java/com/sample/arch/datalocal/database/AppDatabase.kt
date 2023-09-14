package com.sample.arch.datalocal.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sample.arch.datalocal.dao.TransactionDao
import com.sample.arch.datalocal.entity.Transaction

const val DATABASE_NAME = "finance.db"

@Database(
    entities = [
        Transaction::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao

    companion object {
        fun provideDatabase(application: Application) =
            Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
    }
}