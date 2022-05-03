package com.example.workmanagerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val workRequest = OneTimeWorkRequest.Builder(WeatherWorker::class.java).build()
        WorkManager.getInstance(this).enqueue(workRequest)

        // TODO: реализовать запрос погоды
        // TODO: какие параметры позволяет задать WorkManager (макс число одновр заданий)
        // TODO: реализовать выполнение заданий по очереди

    }
}