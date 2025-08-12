package com.spelliar.tools.conventionplugins.local

import java.io.File
import java.util.Properties
import java.util.regex.Pattern

private val versionPattern = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)")
private const val MAJOR_VERSION_OFFSET = 10_000
private const val MINOR_VERSION_MULTIPLIER = 100

internal fun generateVersion(workDir: File): Pair<String, Int> {
    val branchName = System.getenv("CI_COMMIT_BRANCH")
        ?: executeCommands(
            "git rev-parse --abbrev-ref HEAD",
            workDir = workDir
        )
    val tag = executeCommands("git describe --tag --abbrev=0", workDir = workDir)

    val version = if (branchName.startsWith("release")) {
        branchName.replace("release/", "")
    } else {
        tag
    }

    val versionName = if (branchName != "master" && branchName != "HEAD") {
        val commitCountAfterTag = executeCommands("git rev-list $tag.. --count", workDir = workDir)
        val meta = System.getenv("CI_PIPELINE_IID") ?: "0"

        "$version-$commitCountAfterTag+$meta"
    } else {
        version
    }

    val matcher = versionPattern.matcher(version)
    if (!matcher.find()) error("Version $version does not match pattern")

    val major = matcher.group(1)
    val minor = matcher.group(2)
    val fix = matcher.group(3)

    val versionCode =
        major.toInt() * MAJOR_VERSION_OFFSET + minor.toInt() * MINOR_VERSION_MULTIPLIER + fix.toInt()

    val props = Properties()
    props["VERSION_MAJOR"] = major
    props["VERSION_MINOR"] = minor
    props["VERSION_FIX"] = fix
    props["VERSION_NAME"] = versionName

    val propsFile = File("version.properties")
    props.store(propsFile.writer(), null)

    return versionName to versionCode
}

private fun executeCommands(command: String, workDir: File): String {
    val process = ProcessBuilder(command.split(" "))
        .directory(workDir)
        .redirectError(ProcessBuilder.Redirect.PIPE)
        .redirectErrorStream(true)
        .start()

    process.waitFor()

    return process.inputStream
        .bufferedReader()
        .readText()
        .trim()
}
