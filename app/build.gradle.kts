import ru.tsum.tools.conventionplugins.project.extentions.androidMainDependencies
import ru.tsum.tools.conventionplugins.project.extentions.commonMainDependencies
import ru.tsum.tools.conventionplugins.project.extentions.commonTestDependencies
import ru.tsum.tools.conventionplugins.project.extentions.iosMainDependencies

plugins {
    id(libs.plugins.tsum.kmp.app.get().pluginId)
    id(libs.plugins.tsum.compose.get().pluginId)
    id(libs.plugins.tsum.serialization.get().pluginId)
    id(libs.plugins.tsum.tests.get().pluginId)
}

android {
    namespace = "ru.tsum.design"

    defaultConfig {
        applicationId = "ru.tsum.design"
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
}

kotlin {
    androidTarget()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
//    @OptIn(ExperimentalWasmDsl::class)
//    wasmJs {
//        outputModuleName = "composeApp"
//
//        browser {
//            commonWebpackConfig {
//                outputFileName = "composeApp.js"
//            }
//        }
//        binaries.executable()
//    }
}

commonMainDependencies {
    implementation(uikit.navigation.compose)
    // TODO: TOML
    implementation("io.coil-kt.coil3:coil-compose:3.3.0")
    implementation("io.coil-kt.coil3:coil-network-ktor3:3.3.0")
}


commonTestDependencies {
    implementation(projects.palette)
    implementation(core.tsum.core.test)
}

androidMainDependencies {
    implementation(libs.activity.compose)
    implementation(libs.ktor.client.android)
}

iosMainDependencies {
    implementation(libs.ktor.client.native)
}
