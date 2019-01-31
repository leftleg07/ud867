/*

If you check out the source for this project, you'll notice something a little
silly. We've got a hundred classes each with 700 methods. While this is
clearly a contrived example, there's nothing stopping a large project from
getting this big, especially if you've got a lot of big dependencies. Let's
try compiling.

We get the following error:

    trouble writing output: Too many method references: 70936; max is 65536.

Let's unpack what's going on here. The Android virtual machine doesn't
actually run Java byte code, it runs Dalvik byte code, and there's a build
step after Java compilation where the Java byte code is turned into Dalvik
byte code. This step is called Dexing. Part of this process is compiling a
table of every method in the application, which is indexed with two bytes.
That means we're limited to 65k methods.

Fortunately, we can ask Gradle to simply break up this table into multiple
tables simply by setting multiDexEnabled true. That's all there is to it. If
we add that line to defaultConfig and compile again, we're golden.

Just something to be aware of, so you don't get bit in the future.

*/
//
//apply plugin: 'com.android.application'
//
//android {
//    compileSdkVersion 24
//    buildToolsVersion "24.0.1"
//
//    defaultConfig {
//        applicationId "com.udacity.gradle.multidex"
//        minSdkVersion 15
//        targetSdkVersion 24
//        versionCode 1
//        versionName "1.0"
//        // Remove this comment to fix 65k method limit error
//         multiDexEnabled true
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


plugins {
    id(Config.Plugins.androidApplication)
}

android {
    compileSdkVersion(Config.SdkVersions.compile)
    defaultConfig {
        applicationId = "com.udacity.gradle.multidex"
        minSdkVersion(Config.SdkVersions.min)
        targetSdkVersion(Config.SdkVersions.target)
        versionCode = Config.Versions.code
        versionName = Config.Versions.name
        multiDexEnabled = true
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