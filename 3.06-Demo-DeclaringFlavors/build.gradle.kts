/*

Let's add some product flavors! Again, we need to edit the build.gradle file
in the app directory.

*/

// Top-level build file where you can add configuration options common to all sub-projects/modules.

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

/*

Second this block adds the jcenter repository to every subproject of the
build. We'll talk about this multi-project stuff in lesson 4.

*/

allprojects {
    repositories {
        jcenter()
        google()
    }
}

/*

Let's take a look at the build script specifically for the Android app, which
is in the /app directory.

*/

task("clean", Delete::class) {
    description = "clean the build directory"
    delete(rootProject.buildDir)
}

