package com.sample.arch

import android.app.Application
import com.sample.arch.datalocal.di.DataLocalModule
import org.koin.core.context.GlobalContext.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(DataLocalModule.getModule())
        }
    }
}