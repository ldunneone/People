package com.example.people.util

import android.app.Application
import androidx.work.*
import com.example.people.di.*
import com.example.people.util.background.PersonWorker
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import java.util.concurrent.TimeUnit

class PeopleApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin()
        startWorkManager()
    }

    private fun startKoin(){
        org.koin.core.context.startKoin {
            androidContext(this@PeopleApp)
            androidLogger(Level.ERROR)
            modules(netModule, apiModule, databaseModule, repoModule, viewModelModule)
        }
    }

    private fun startWorkManager(){
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .setRequiresCharging(false)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(false)
            .build()

        //Set the frequency at which the job should be executed
        val repeatingRequest = PeriodicWorkRequestBuilder<PersonWorker>(1, TimeUnit.HOURS)
            //Add the device constraints
            .setConstraints(constraints)
            .build()

        //Schedule the work to be completed
        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            PersonWorker.WORK_LOCATION,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest
        )
    }
}