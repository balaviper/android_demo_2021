package com.example.workermanager.worker

import android.content.Context
import androidx.lifecycle.Observer
import androidx.work.*
import com.example.workermanager.worker.FileUploadWork.Companion.Progress
import java.util.concurrent.TimeUnit
import androidx.work.WorkManager

import androidx.work.OneTimeWorkRequest

import androidx.work.NetworkType




internal fun scheduleOnce(context : Context) {
    val uploadRequest = OneTimeWorkRequestBuilder<FileUploadWork>().build()
    WorkManager.getInstance(context).enqueue(uploadRequest)
}

internal fun scheduleRepeating(context : Context) {
    val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.UNMETERED)
        .setRequiresCharging(true)
        .build()

    val uploadRequest = PeriodicWorkRequestBuilder<FileUploadWork>(
        15,
        TimeUnit.MINUTES
    ).setConstraints(constraints).build()

    WorkManager.getInstance(context).enqueue(uploadRequest)
}


internal fun scheduleOnceWithData(context: Context) {
    val uploadRequest = OneTimeWorkRequestBuilder<FileUploadWork>()
        .setInputData(
            workDataOf(
                "KEY_FILE_NAME" to "abc.txt",
                "KEY_FILE_SIZE" to 10L
            )
        )
        .build()
    WorkManager.getInstance(context).enqueue(uploadRequest)
}

