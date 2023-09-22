package com.sample.arch.datalocal.di

import com.sample.arch.datalocal.database.AppDatabase
import com.sample.data.transaction.dao.TransactionDao
import org.koin.dsl.module

object DataLocalModule {

    fun getModule() = module{
        // RoomDatabase
        single { AppDatabase.provideDatabase(get()) }

        // DAO
        factory { get<AppDatabase>().transactionDao() }
    }
}