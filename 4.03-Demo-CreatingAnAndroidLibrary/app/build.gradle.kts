//apply plugin: 'com.android.application'
//
//android {
//    compileSdkVersion 24
//    buildToolsVersion "24.0.1"
//
//    defaultConfig {
//        applicationId "com.udacity.gradle.androidlibrarydemo"
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
    id(Config.Plugins.androidApplication)
}

android {
    compileSdkVersion(Config.SdkVersions.compile)
    defaultConfig {
        applicationId = "com.udacity.gradle.androidlibrarydemo"
        minSdkVersion(Config.SdkVersions.min)
        targetSdkVersion(Config.SdkVersions.target)
        versionCode = Config.Versions.code
        versionName = Config.Versions.name
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(project(":imageactivity"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Config.Libs.Support.appCompat)
}
/*

Now if we add a compile time dependency on the imageactivity project, we can
now access classes and resources declared in that library! Let's wire up a
button to launch the activity from our library.

*/


//dependencies {
//    compile fileTree(dir: 'libs', include: ['*.jar'])
//    compile 'com.android.support:appcompat-v7:24.1.1'
//    compile project(":imageactivity")
//}
