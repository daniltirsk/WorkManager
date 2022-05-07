package com.example.workmanagerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import androidx.work.workDataOf


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val myData1: Data = workDataOf("CITY" to "Svirsk")
        val myData2: Data = workDataOf("CITY" to "Irkutsk")
        val myData3: Data = workDataOf("CITY" to "Angarsk")


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val workRequest1 = OneTimeWorkRequest.Builder(WeatherWorker::class.java).setInputData(myData1).build()
        val workRequest2 = OneTimeWorkRequest.Builder(WeatherWorker::class.java).setInputData(myData2).build()
        val workRequest3 = OneTimeWorkRequest.Builder(WeatherWorker::class.java).setInputData(myData3).build()
        WorkManager.getInstance(this).beginWith(workRequest1)
            .then(workRequest2)
            .then(workRequest3).enqueue()
    }
}