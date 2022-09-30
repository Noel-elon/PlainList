plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.noelon.core_database"
    compileSdk = Config.Versions.compileSdkVersion

    defaultConfig {
        minSdk = Config.Versions.minSdkVersion
        targetSdk = Config.Versions.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    //Room
    implementation(AppDependencies.Local.roomRuntime)
    implementation(AppDependencies.Local.roomKtx)
    kapt(AppDependencies.Local.roomCompiler)

    // hilt
    implementation(AppDependencies.DI.hiltAndroid)
    kapt(AppDependencies.DI.hiltCompiler)

    //test
    testImplementation(AppDependencies.Test.JUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXTestJUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXComposeTest)
}