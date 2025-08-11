import ru.tsum.tools.conventionplugins.extensions.libs

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.tsum.detekt) apply true
}

buildscript {
    repositories {
        mavenLocal()
        maven(url = "https://repo.int.tsum.com/repository/maven-snapshots/")
        maven(url = "https://repo.int.tsum.com/repository/maven-releases/")
        google()
        gradlePluginPortal()
        maven(url = "https://androidx.dev/storage/compose-compiler/repository/")
    }
    dependencies {
        classpath(libs.gradleplugin.project)
    }
}

configureDetekt {
    enableTypeResolution()
    autoCorrect = !project.properties.containsKey("ci")
    configPath = "$rootDir/detekt.yml"
    sarifReport = rootProject.layout.buildDirectory.file("reports/detekt/merge.sarif").get()
    detektPlugins(libs.detekt.formatting)
    detektPlugins(libs.detekt.twitter.rules)
}