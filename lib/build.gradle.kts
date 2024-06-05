/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin library project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.6/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.jvm)

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    `maven-publish`
    signing
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {

    implementation("io.github.llschall:ardwloop:0.1.2")

    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation(libs.junit.jupiter.engine)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api(libs.commons.math3)

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation(libs.guava)
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

val publish = project.hasProperty("ossrh_user")

if (!publish) {
    println("=== Publish skipped because no credential is provided. ===")
}

publishing {
    if (publish) {
        publications {
            create<MavenPublication>("ardwloop-ext") {
                from(components["java"])

                groupId = "io.github.llschall"
                artifactId = "ardwloop-ext"
                version = "0.1-SNAPSHOT"

                pom {
                    signing {
                        sign("publishing.publications.ardwloop-ext")
                        sign("configurations.archives")
                    }

                    name = "ardwloop-ext"
                    description =
                        "An extended version of ardwloop, with Bluetooth support for Android."
                    url = "https://github.com/llschall/ardwloop-ext"
                    licenses {
                        license {
                            name = "The Apache License, Version 2.0"
                            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                        }
                    }
                    developers {
                        developer {
                            id = "llschall"
                            name = "Laurent Schall"
                            email = "llschall@gmx.com"
                        }
                    }
                    scm {
                        url = "https://github.com/llschall/ardwloop-ext.git"
                    }
                }
            }
        }
        repositories {
            maven {
                credentials {
                    username = project.properties["ossrh_user"].toString()
                    password = project.properties["ossrh_pwd"].toString()
                }
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
            }
        }
    }
}

