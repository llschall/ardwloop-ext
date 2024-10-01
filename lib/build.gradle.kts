plugins {
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.android.library)

    `maven-publish`
    signing
}

android {
    namespace = "org.llschall.ardwloop.ext"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    api(libs.ardwloop)

    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.bluetooth)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

if (!project.hasProperty("token_usr")) {
    println("=== Publish skipped because no credential is provided. ===")
} else {
    val user: String = project.properties["token_usr"].toString()
    val pwd: String = project.properties["token_pwd"].toString()

    afterEvaluate {
        publishing {
            publications {
                create<MavenPublication>("ardwloop-ext") {
                    from(components["release"])

                    groupId = "io.github.llschall"
                    artifactId = "ardwloop-ext"
                    version = "0.1.3-SNAPSHOT"

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
}