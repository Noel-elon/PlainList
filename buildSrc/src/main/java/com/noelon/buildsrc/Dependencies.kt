import AppDependencies.Versions.hiltNavigationVersion

object AppDependencies {
    object Versions {
        internal const val ANDROID_GRADLE_PLUGIN = "7.1.0"
        internal const val ANDROID_GRADLE_SPOTLESS = "6.7.0"
        internal const val KOTLIN = "1.7.10"
        internal const val KOTLIN_SERIALIZATION_JSON = "1.4.0"
        internal const val KSP = "1.7.10-1.0.6"

        internal const val androidXcoreVersion = "1.8.0"
         const val composeVersion = "1.2.1"
        internal const val navVersion = "2.5.2"
        const val kotlinCompilerExtVersion = "1.3.0"
        internal const val lifecycleRuntimeVersion = "2.5.1"
        internal const val lifecycleComposeVersion = "2.6.0-alpha01"
        internal const val activityComposeVersion = "1.5.1"

        /**
         * Test Versions
         */
        internal const val androidXTestVersion = "1.1.3"
        internal const val androidXEspressoVersion = "3.4.0"
        internal const val JUnitVersion = "4.13.2"

        /**
         * Network
         */
        internal const val retrofitVersion = "2.9.0"
        internal const val okhttpVersion = "4.10.0"
        internal const val moshiVersion = "1.13.0"
        internal const val coroutinesVersion = "1.6.4"
        internal const val sandwichVersion = "1.3.0"

        internal const val kotlin = "1.7.10"
        internal const val kotlinSerialization = "1.4.0"

        /**
         * DI
         */

        internal const val hiltVersion = "2.42"
        internal const val hiltNavigationVersion = "1.0.0-alpha03"

        /**
         * Cache
         */
        internal const val room = "2.4.2"

        internal const val datastoreVersion = "1.0.0"

        /**
         * Google
         */
        internal const val playServicesVersion = "20.3.0"


        internal const val coilVersion = "2.2.2"

    }

    object AndroidX {
        const val androidCoreKtx: String = "androidx.core:core-ktx:${Versions.androidXcoreVersion}"
        const val composeUi = "androidx.compose.ui:ui:${Versions.composeVersion}"
        const val composeMaterial = "androidx.compose.material:material:${Versions.composeVersion}"
        const val composeToolingPreview =
            "androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}"
        const val lifecycleKtx =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeVersion}"
        const val composeLifecycle = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleComposeVersion}"
        const val activityCompose =
            "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
        const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navVersion}"
        const val androidXTestJUnit = "androidx.test.ext:junit:${Versions.androidXTestVersion}"
        const val androidXEspresso =
            "androidx.test.espresso:espresso-core:${Versions.androidXEspressoVersion}"
        const val androidXComposeTest =
            "androidx.compose.ui:ui-test-junit4:${Versions.composeVersion}"
        const val androidXComposeTooling =
            "androidx.compose.ui:ui-tooling:${Versions.composeVersion}"

    }

    object AndroidConfig {
        const val androidGradlePlugin =
            "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val kotlinSerializationPlugin =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.KOTLIN}"
        const val kotlinSerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.KOTLIN_SERIALIZATION_JSON}"
        const val ksp = "com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Versions.KSP}"
        const val spotlessGradlePlugin =
            "com.diffplug.spotless:spotless-plugin-gradle:${Versions.ANDROID_GRADLE_SPOTLESS}"
        const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    }

    object Google {
        const val googlePlayServices = "com.google.android.gms:play-services-auth:${Versions.playServicesVersion}"
    }

    object Test {
        const val JUnit = "junit:junit:${Versions.JUnitVersion}"
    }

    object Network {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
        const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"

        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshiVersion}"
        const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}"

        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}"

        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
        const val sandwich = "com.github.skydoves:sandwich:${Versions.sandwichVersion}"

        const val kotlinSerializationPlugin =
            "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlin}"
        const val kotlinSerializationJson =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinSerialization}"
    }

    object Local {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val datastore = "androidx.datastore:datastore-preferences:${Versions.datastoreVersion}"
    }

    object DI {
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hiltVersion}"
        const val hiltTest = "com.google.dagger:hilt-android-testing:${Versions.hiltVersion}"

        const val hiltNavigation = "androidx.hilt:hilt-navigation:${hiltNavigationVersion}"
        const val hiltCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    }

    object Utils {
        const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilVersion}"
    }
}

object Config {
    object Versions {
        const val minSdkVersion: Int = 21
        const val compileSdkVersion: Int = 32
        const val targetSdkVersion: Int = 32
        const val versionName: String = "1.0"
        const val versionCode: Int = 1
    }

    const val isMultiDexEnabled: Boolean = true

    object Android {
        const val applicationId: String = "com.noelon.noelcompose"
        const val testImplementationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}