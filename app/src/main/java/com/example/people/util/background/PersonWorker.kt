package com.example.people.util.background

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.people.repository.PersonRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class PersonWorker (appContext: Context, parameters: WorkerParameters) :
    CoroutineWorker(appContext, parameters), KoinComponent {

    private val personRepository: PersonRepository by inject()

    companion object {
        const val WORK_LOCATION = "com.example.people.util.background.PersonWorker"
    }

    override suspend fun doWork(): Result {
        try {
            personRepository.getPeople()
        } catch (e: Exception) {
            return Result.retry()
        }
        return Result.success()
    }
}