package com.example.smartshoeshop

import android.app.Application
import com.google.firebase.FirebaseApp

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Initialize Firebase
        FirebaseApp.initializeApp(this) // this refers to the Application context
    }
}
