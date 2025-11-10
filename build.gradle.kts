// Top-level build file where you can add configuration options common to all sub-projects/modules.
//noinspection UseTomlInstead
buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.4.4")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    id("com.google.dagger.hilt.android") version "2.57.1" apply false
    id("com.google.devtools.ksp") version "2.2.21-2.0.4" apply false
}