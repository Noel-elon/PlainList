buildscript {
    repositories {
        google()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath(AppDependencies.AndroidConfig.androidGradlePlugin)
        classpath(AppDependencies.AndroidConfig.kotlinGradlePlugin)
        classpath(AppDependencies.AndroidConfig.kotlinSerializationPlugin)
        classpath(AppDependencies.AndroidConfig.ksp)
        classpath(AppDependencies.AndroidConfig.hiltPlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
