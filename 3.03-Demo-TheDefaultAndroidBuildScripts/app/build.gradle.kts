/*

Here's the build script specifically for the Android app. Note that it first
applies the Android plugin, which it fetched from jcenter. All configuration
of the Android plugin happens in the `android` configuration block. All that's
absolutely required are the first two lines defining the SDK version and the
build tools version. The `defaultConfig` block configures attributes of the
Android Manifest. We'll talk about the `buildTypes` block momentarily.

*/

//
//apply plugin: 'com.android.application'
//
//android {
//    compileSdkVersion 25
//    buildToolsVersion "24.0.3"
//
//    defaultConfig {
//        applicationId "com.example.android.myapplication"
//        minSdkVersion 15
//        targetSdkVersion 25
//        versionCode 1
//        versionName "1.0"
//    }
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//}
//

plugins {
    id("com.android.application")
}

android {
    compileSdkVersion (28)
        defaultConfig {
        applicationId = "com.example.android.myapplication"
        minSdkVersion(15)
        targetSdkVersion(26)
        versionCode = 1
        versionName = "1.0"
    }

        buildTypes {
            getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

///*
//
//This block works just like Java dependencies. This declares compile time
//dependencies on every JAR in the `libs` directory, and on the Android support
//library. We'll also be talking about this block more soon.
//
//*/
//
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("com.android.support:appcompat-v7:28.0.0")
}
