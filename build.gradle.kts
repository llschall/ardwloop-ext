// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    `maven-publish`
    signing
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
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
val user: String = project.properties["ossrh_user"].toString()
val pwd: String = project.properties["ossrh_pwd"].toString()

publishing {
    if (publish) {
        publications {
            create<MavenPublication>("ardwloop-ext") {
                from(components["java"])

                groupId = "io.github.llschall"
                artifactId = "ardwloop-ext"
                version = "0.1.2-SNAPSHOT"

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
                    username = user
                    password = pwd
                }
                url = uri("https://s01.oss.sonatype.org/content/repositories/snapshots")
                // url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2")
            }
        }
        signing {
            sign(publishing.publications["ardwloop-ext"])
        }
    }
}
