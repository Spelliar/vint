plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradle.plugin)

    // Workaround for version catalog working inside precompiled scripts
    // Issue - https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(libs.gradleplugin.base)
}

gradlePlugin {
    plugins {
        register("app-version") {
            id = "app-version"
            implementationClass = "com.spelliar.tools.conventionplugins.local.ApplicationVersionPlugin"
        }
    }
}
