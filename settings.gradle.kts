@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("convention-plugins-local")
    repositories {
        mavenLocal()
        maven(url = "https://repo.int.tsum.com/repository/maven-snapshots/")
        maven(url = "https://repo.int.tsum.com/repository/maven-releases/")
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) TODO: uncomment when resolved https://youtrack.jetbrains.com/issue/KT-68533/Kotlin-2.0-WasmJs-error-when-using-RepositoriesMode.FAILONPROJECTREPOS
    versionCatalogs {
        create("uikit") {
            from(files("uikit.versions.toml"))
        }
        create("core") {
            from("ru.tsum.kmp.core:version-catalog:1.0.3")
        }
        create("libs") {
            from("ru.tsum.tools.conventionplugins:version-catalog:2.0.2")
        }
    }
    repositories {
        mavenLocal()
        maven(url = "https://repo.int.tsum.com/repository/maven-snapshots/")
        maven(url = "https://repo.int.tsum.com/repository/maven-releases/")
        mavenCentral()
        google()
        gradlePluginPortal()
    }
}

rootProject.name = "AndroidTsumDesign"

include(":app")
include(":models")
include(":palette")
include(":uikit")
