/*

Let's check out where and how to configure build types. Since build types are
only relevant to the Android component of this build, we need to check out the
build.gradle file in the `app` folder. See you there!

*/

// Top-level build file where you can add configuration options common to all
// sub-projects/modules.

buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.3.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
        google()
    }
}

task("clean", Delete::class) {
    description = "clean the build directory"
    delete(rootProject.buildDir)
}
