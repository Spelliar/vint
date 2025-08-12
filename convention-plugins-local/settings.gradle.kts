@file:Suppress("UnstableApiUsage")

rootProject.name = "local"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from("ru.tsum.tools.conventionplugins:version-catalog:2.0.1")
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
