package com.example.workmanagerdemo

import android.content.Context
import android.util.Log
import android.content.res.Resources
import android.provider.Settings.Global.getString
import android.provider.Settings.System.getString
import androidx.core.content.res.TypedArrayUtils.getString
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.io.InputStream
import java.net.URL
import java.util.*

const val KEY_CITY_ARG = "CITY"

const val KEY_RESULT = "result"


class WeatherWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams)
{
    override fun doWork(): Result {
        val city = inputData.getString(KEY_CITY_ARG)
        if (city != null) {
            Log.d("mytag", city)
        }
        val API_KEY = "d6843ab8ee963f5d372296dfff62aed7"
        val weatherURL = "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric";
        val stream: InputStream
        try {
            stream = URL(weatherURL).getContent() as InputStream
        } catch (e: Exception){
            Log.d("mytag", e.toString())
            return Result.failure()
        }

        val data = Scanner(stream).nextLine()
        Log.d("mytag", data)

        return Result.success()
    }
}