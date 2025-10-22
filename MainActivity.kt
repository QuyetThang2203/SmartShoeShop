package com.example.smartshoeshop

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.google.firebase.analytics.FirebaseAnalytics

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val analytics = FirebaseAnalytics.getInstance(this)
        analytics.logEvent("app_started", null)

        Log.d("Firebase", "Firebase initialized successfully!") // Log to confirm initialization
    }
}