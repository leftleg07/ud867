import org.gradle.internal.impldep.com.amazonaws.PredefinedClientConfigurations.defaultConfig

//apply plugin: 'com.android.application'
//
//android {
//    compileSdkVersion 24
//    buildToolsVersion "24.0.1"
//
//    defaultConfig {
//        applicationId "com.udacity.gradle.javalibrarydemo"
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
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.udacity.gradle.javalibrarydemo"
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

Now we need to declare a compile time dependency on the project :javaJokes

This bit is a little tricky. The Java plugin defines an extra "default"
configuration we haven't talked about yet. It adds its output: its JAR, to
that configuration. When we declare our dependency on the :javaJokes project,
we're actually depending on the "default" configuration of :javaJokes, which
contains the output JAR.

*/

dependencies {
    implementation(project(":javaJokes"))
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("com.android.support:appcompat-v7:28.0.0")
}

/*

Finally, we need to actually use the library. Give the textView in
fragment_main.xml an id, we used textView. Then in MainActivityFragment, add:

    import com.udacity.gradle.jokes.Joker;

Then replace onCreateView in MainActivityFragment with the following.


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.textView);
        Joker myJoker = new Joker();
        textView.setText(myJoker.getJoke());
        return rootView;
    }

Then we're ready to build! When you run the build, watch the Gradle Console,
which you can open at the bottom right of Android Studio. You'll notice
something like this:

:app:preBuild UP-TO-DATE
:app:preDebugBuild UP-TO-DATE
:app:compileDebugNdk UP-TO-DATE
:app:checkDebugManifest
:app:preReleaseBuild UP-TO-DATE
:javaJokes:compileJava
:javaJokes:processResources UP-TO-DATE
:javaJokes:classes
:javaJokes:jar
:app:prepareComAndroidSupportAppcompatV72210Library UP-TO-DATE
:app:prepareComAndroidSupportSupportV42210Library UP-TO-DATE
:app:prepareDebugDependencies

The app project was running some tasks, then the javaJokes project jumped in
to create a JAR for the app project to use!

That's all there is to it to add a Java library project to an Android Studio build!

*/