plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization")
}

kotlin {
    androidTarget()
    ios()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation("dev.gitlive:firebase-firestore:1.11.0")
                implementation("dev.gitlive:firebase-auth:1.11.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.google.firebase:firebase-auth-ktx:23.2.0")
                implementation("com.google.firebase:firebase-firestore-ktx:24.11.0")
            }
        }
        val iosMain by getting
    }
}

android {
    namespace = "com.vint.shared"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}
