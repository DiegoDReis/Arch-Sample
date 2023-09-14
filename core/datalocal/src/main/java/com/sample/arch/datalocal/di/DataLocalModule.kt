package com.sample.arch.datalocal.di

import com.sample.arch.datalocal.database.AppDatabase
import org.koin.dsl.module

object DataLocalModule {

    fun getModule() = module{
        // RoomDatabase
        single { AppDatabase.provideDatabase(get()) }

        // DAO
        factory { get<AppDatabase>().transactionDao() }

    }
}