// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()

    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.2")
        classpath ("com.google.gms:google-services:4.4.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.21")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.45")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("com.android.application") version "8.1.1" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false
}