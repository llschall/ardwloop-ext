// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.android.library) apply false

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    `maven-publish`
    signing
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
    withJavadocJar()
    withSourcesJar()
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}