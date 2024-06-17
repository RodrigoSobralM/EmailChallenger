pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.0.0"
        id("org.jetbrains.kotlin.android") version "1.7.10"
        id("kotlin-kapt") version "1.7.10"
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "email"
include(":app")
