package com.example.workermanager.worker

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.delay

class FileUploadWork(
    private val context: Context,
    private val params: WorkerParameters
) : Worker(context, params) {

    companion object {
        const val Progress = "Progress"
        private const val delayDuration = 1L
    }

    override fun doWork(): Result {
        Log.i("@ani", "Doing File Upload")
        val nm = inputData.getString("KEY_FILE_NAME")
        val sz = inputData.getLong("KEY_FILE_SIZE", -1L)
        Log.i("@ani", "Name: $nm, Size: $sz")
        return Result.retry()
    }

}


class SampleProgressWork(
    private val context : Context,
    private val params : WorkerParameters
) : CoroutineWorker(context, params) {

    companion object {
        const val KEY_FILE_PROGRESS = "key_progress"
    }

    override suspend fun doWork(): Result {
        for (i in 0..100) {
            val prg = workDataOf( KEY_FILE_PROGRESS to i)
            delay(500)
            setProgress(prg)
        }
        return Result.success()
    }
}

class NetworkCheck(
    private val context : Context,
    private val params : WorkerParameters
) : CoroutineWorker(context, params) {

    companion object {
        const val KEY_Network = "key_network"
    }

    override suspend fun doWork(): Result {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
        val isConnected: Boolean = activeNetwork?.isConnectedOrConnecting == true

        val prg = workDataOf( NetworkCheck.KEY_Network to isConnected)
        setProgress(prg)
        return Result.success()
    }
}
