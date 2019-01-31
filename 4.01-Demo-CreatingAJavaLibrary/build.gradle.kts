/*

Now that our Java joke telling code is really coming along, we should probably
break it out into its own library. That way we can reuse it across projects.
There's a wizard that makes it super easy to add a Java library project, but
we'll first do it by hand.

First we just need to create a Gradle Java project, like we've been doing all
along. We'll root the project at javaJokes. Head over to that build.gradle
file for more info.

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

