plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.noelon.core_designsystem"
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppDependencies.Versions.kotlinCompilerExtVersion
    }
}

dependencies {

    implementation(AppDependencies.AndroidX.androidCoreKtx)
    implementation(AppDependencies.AndroidX.activityCompose)
    implementation(AppDependencies.AndroidX.composeUi)
    implementation(AppDependencies.AndroidX.composeMaterial)
    implementation(AppDependencies.AndroidX.composeToolingPreview)
    implementation(AppDependencies.AndroidX.composeLifecycle)
    debugImplementation(AppDependencies.AndroidX.androidXComposeTooling)
}