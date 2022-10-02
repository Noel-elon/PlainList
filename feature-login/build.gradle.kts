plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.noelon.feature_login"
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

    implementation(project(":core-common"))
    implementation(project(":core-data"))
    implementation(project(":core-designsystem"))

    implementation(AppDependencies.AndroidX.activityCompose)
    implementation(AppDependencies.AndroidX.composeUi)
    implementation(AppDependencies.AndroidX.composeMaterial)
    implementation(AppDependencies.AndroidX.composeToolingPreview)
    implementation(AppDependencies.AndroidX.composeLifecycle)
    debugImplementation(AppDependencies.AndroidX.androidXComposeTooling)

    implementation(AppDependencies.DI.hiltNavigation)
    implementation(AppDependencies.DI.hiltCompose)
    implementation(AppDependencies.DI.hiltAndroid)
    kapt(AppDependencies.DI.hiltCompiler)

    //test
    testImplementation(AppDependencies.Test.JUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXTestJUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXComposeTest)
}