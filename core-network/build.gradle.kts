buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.Versions.compileSdkVersion
    namespace = Config.Android.applicationId

    defaultConfig {
        minSdk = Config.Versions.minSdkVersion
        targetSdk = Config.Versions.targetSdkVersion
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    api(AppDependencies.Network.retrofit)
    api(AppDependencies.Network.moshiConverter)
    api(AppDependencies.Network.loggingInterceptor)
    api(AppDependencies.Network.okHttp)
    api(AppDependencies.Network.sandwich)
    // hilt
    implementation(AppDependencies.DI.hiltAndroid)
    kapt(AppDependencies.DI.hiltCompiler)

    // moshi
    api(AppDependencies.Network.moshiKotlin)
    kapt(AppDependencies.Network.moshiCodegen)

    // coroutines
    api(AppDependencies.Network.coroutinesAndroid)

    //test
    testImplementation(AppDependencies.Test.JUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXTestJUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXComposeTest)

}