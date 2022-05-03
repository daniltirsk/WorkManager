package com.example.workmanagerdemo

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class WeatherWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams)
{
    override fun doWork(): Result {
        Log.d("mytag", "work success")
        return Result.success()
    }
}