/*

While it's totally possible to add an Android library project manually, it's a
lot easier to use the wizard. Let's create an Android Library that defines an
activity that will display the Gradle logo.

The process is almost identical to creating a new Android app. We'll navigate
to:

    New > New Module > Phone and Tablet Application > Android Library

and create a new library called imageactivity, and add an activity with a
fragment. We'll name the Activity ImageActivity.

Now we'll add a drawable and modify the fragment's layout to show off the
image. We'll also add a new string for the textView to display. Alright! So
let's compile and run our app.

Hmm... No trace of our image... Oh right! We weren't editing an activity
that's part of our app, we were editing the activity in the library, which we
haven't yet referenced from our app. First let's verify that our library was
added as a subproject in our settings.gradle file.

*/

// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath(Config.Plugins.androidGradle)

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
