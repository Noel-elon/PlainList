plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.noelon.core_data"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

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
    implementation(project(":core-common"))
    implementation(project(":core-database"))
    implementation(project(":core-network"))

    implementation(AppDependencies.DI.hiltAndroid)
    kapt(AppDependencies.DI.hiltCompiler)

    //test
    testImplementation(AppDependencies.Test.JUnit)
    testImplementation(AppDependencies.Test.mockk)
    testImplementation(AppDependencies.Test.coroutineTest)
    androidTestImplementation(AppDependencies.AndroidX.androidXTestJUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXComposeTest)
}