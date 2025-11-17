plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // KSP plugin — CHUẨN CHO KOTLIN 2.0.21
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false

    // Firebase
    id("com.google.gms.google-services") version "4.4.4" apply false

    // Hilt plugin
    id("com.google.dagger.hilt.android") version "2.47" apply false
}
