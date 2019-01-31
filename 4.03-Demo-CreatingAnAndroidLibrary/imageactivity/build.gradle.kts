//apply plugin: 'com.android.library'
//
//android {
//    compileSdkVersion 24
//    buildToolsVersion "24.0.1"
//
//    defaultConfig {
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
//
//dependencies {
//    compile fileTree(dir: 'libs', include: ['*.jar'])
//    compile 'com.android.support:appcompat-v7:24.1.1'
//}
//
//android {
//    lintOptions {
//        disable 'IconMissingDensityFolder'
//    }
//}


plugins {
    id(Config.Plugins.androidLibrary)
}

android {
    compileSdkVersion(Config.SdkVersions.compile)
    defaultConfig {
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Config.Libs.Support.appCompat)
}