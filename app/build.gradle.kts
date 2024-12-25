plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.lekarskaordinacija"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.lekarskaordinacija"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
    buildToolsVersion = "35.0.0"
}

dependencies {
    // Existing implementations
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth)
    implementation(libs.glide)

    // Testing dependencies
    // JUnit
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)

    // Espresso
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.espresso.intents)

    // Mockito for unit testing
    testImplementation("org.mockito:mockito-core:4.5.1")
    testImplementation("org.mockito:mockito-inline:4.5.1")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")

    // AndroidX Test Core library
    testImplementation("androidx.test:core:1.5.0")
    androidTestImplementation("androidx.test:core:1.5.0")

    // AndroidX Test Rules library
    androidTestImplementation("androidx.test:rules:1.5.0")

    // AndroidX Test Runner library
    androidTestImplementation("androidx.test:runner:1.5.0")

    // Kotlin Coroutines Test
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")

    // AndroidX Arch Core Testing
    testImplementation("androidx.arch.core:core-testing:2.2.0")

    // Mockk for alternative mocking (optional, but powerful)
    testImplementation("io.mockk:mockk:1.13.5")

    testImplementation ("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")

    // Hamcrest for additional matchers
    testImplementation("org.hamcrest:hamcrest-library:2.2")
    androidTestImplementation(libs.androidx.core.testing)
}