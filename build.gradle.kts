plugins {
    id("com.android.application")
}

android {
    namespace = "com.alpha.applock"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.alpha.applock"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
}
