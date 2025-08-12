package com.spelliar.tools.conventionplugins.local

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import com.spelliar.tools.conventionplugins.extensions.commonAndroid

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
