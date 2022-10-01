plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.noelon.noelcompose"
    compileSdk = 32

    defaultConfig {
        applicationId = Config.Android.applicationId
        minSdk = Config.Versions.minSdkVersion
        targetSdk = Config.Versions.targetSdkVersion
        compileSdk = Config.Versions.compileSdkVersion
        versionCode = Config.Versions.versionCode
        versionName = Config.Versions.versionName

        testInstrumentationRunner = Config.Android.testImplementationRunner
        vectorDrawables {
            useSupportLibrary =  true
        }
    }

    buildTypes {
        named(BuildType.RELEASE) {
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        named(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
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
    packagingOptions {
        resources {
            excludes.add("META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":core-designsystem"))
    implementation(project(":core-common"))
    implementation(project(":core-navigation"))
    implementation(project(":feature-login"))
    implementation(project(":feature-search"))

    implementation(AppDependencies.AndroidX.androidCoreKtx)
    implementation(AppDependencies.AndroidX.composeUi)
    implementation(AppDependencies.AndroidX.composeMaterial)
    implementation(AppDependencies.AndroidX.composeToolingPreview)
    implementation(AppDependencies.AndroidX.lifecycleKtx)
    implementation(AppDependencies.AndroidX.activityCompose)
    implementation(AppDependencies.DI.hiltAndroid)
    implementation(AppDependencies.DI.hiltNavigation)
    implementation(AppDependencies.DI.hiltCompose)
    kapt(AppDependencies.DI.hiltCompiler)
    testImplementation(AppDependencies.Test.JUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXTestJUnit)
    androidTestImplementation(AppDependencies.AndroidX.androidXEspresso)
    androidTestImplementation(AppDependencies.AndroidX.androidXComposeTest)
    debugImplementation(AppDependencies.AndroidX.androidXComposeTooling)
}