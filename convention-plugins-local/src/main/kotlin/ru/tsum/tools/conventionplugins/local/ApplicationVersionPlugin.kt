package ru.tsum.tools.conventionplugins.local

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import ru.tsum.tools.conventionplugins.extensions.commonAndroid

class ApplicationVersionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            commonAndroid {
                this as BaseAppModuleExtension
                val (verName, verCode) = generateVersion(projectDir.parentFile)
                defaultConfig {
                    versionCode = verCode
                    versionName = verName
                }
            }
        }
    }
}
