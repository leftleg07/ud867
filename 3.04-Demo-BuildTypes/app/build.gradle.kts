/*

Build types are defined in the `buildTypes { }` script block. Here we can see
that Android Studio has already added some additional configuration to the
release build type for us. Although debug isn't listed here, the debug build
type still exists. In this case we are disabling packaging optimizations by
setting 'minifyEnabled' to false. Also we are configuring where the Android
plugin should look for Proguard configuration. We'll talk more about Proguard
in lesson 4.

*/

//apply plugin: 'com.android.application'
//
//android {
//    compileSdkVersion 24
//    buildToolsVersion "24.0.1"
//
//    defaultConfig {
//        applicationId "com.example.udacity.myapplication"
//        minSdkVersion 15
//        targetSdkVersion 24
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

plugins {
    id("com.android.application")
}

android {
    compileSdkVersion (28)
    defaultConfig {
        applicationId = "com.example.udacity.myapplication"
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

/*

If we look at the available tasks for our project, you'll see tasks
corresponding to each build type. We can generate the debug APK by running
'assembleDebug', and similarly we get the release APK by running
'assembleRelease'.

We can also add new build types of our own, and want to make a build for QA
testing that's like the release build, except it bundles in cheats for
infinite gold or to skip levels, or whatever. We can easily declare a
qaTesting build types in the `buildTypes { }` script block.

*/

android {
    buildTypes {
        create("qaTesting")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("com.android.support:appcompat-v7:28.0.0")
}
