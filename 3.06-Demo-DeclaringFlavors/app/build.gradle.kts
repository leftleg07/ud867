/*

In addition to build types, product flavors are another way for us to describe
variants of our application in our build. Flavors are similar to build types
except they are typically used to create different versions of our app that
users might install. A very common example is creating both a free and paid
version of your app.

Let's make an app with a free flavor and a paid flavor. Unlike build types,
the Android plugin does not create any product flavors for us default. If we
want to declare some flavors we do so just like we do with build types, except
that we place them in a `productFlavors { }` script block. Let's go ahead and
create our free and paid flavors, and assign them unique application ids. That
way we can install both flavors on the same device.

*/

//apply plugin: 'com.android.application'
//
//android {
//    compileSdkVersion 24
//    buildToolsVersion "24.0.1"
//
//    defaultConfig {
//        applicationId "com.example.udacity.declaringflavors"
//        minSdkVersion 15
//        targetSdkVersion 24
//        versionCode 1
//        versionName "1.0"
//    }
//
//    buildTypes {
//        release {
//            minifyEnabled false
//            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
//        }
//    }
//
//    productFlavors {
//        free {
//            applicationId "com.example.udacity.declaringflavors.free"
//        }
//        paid {
//            applicationId "com.example.udacity.declaringflavors.paid"
//        }
//    }
//}


plugins {
    id("com.android.application")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "com.example.udacity.declaringflavors"
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
        create("qaTest")
    }

    flavorDimensions("version")
    productFlavors {
        create("free") {
            dimension = "version"
            applicationId = "com.example.udacity.declaringflavors.free"
        }
        create("paid") {
            dimension = "version"
            minSdkVersion(23)
            applicationId = "com.example.udacity.declaringflavors.paid"
        }
//        free {
//            applicationId("com.example.udacity.declaringflavors.free")
//        }
//        paid {
//            applicationId("com.example.udacity.declaringflavors.paid")
//        }
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
/*

By default, source that is located in the 'main' source set is included in all
app variants, however, we when declare additional flavors, the Android plugin
automatically creates new source sets for us that we can use to place flavor-
specific code and resources. Not surprisingly, these source sets are simply
named whatever we named our flavors. Continuing with our free vs paid example,
for our 'free' product flavor, our Java code and resources for the 'free'
variant would be located in 'src/free/java' and 'src/free/res', respectively.
When Gradle builds each app variant it will automatically bundle the
additional source in each of the flavor-specific folders.

The new app template in Android Studio makes an app that just displays a
string. Let's add strings that are specific to the free and paid flavors. We
can just right click the app directory, and select New > Android resource
file. We'll name the file `strings`, and change the source set from `main` to
`paid`, and add a string with a custom message.

Let's do the same thing for the free flavor.

Now, to actually run each flavor, we can bring up the Build Variants pane at
the bottom left of Android studio. If we select freeDebug and hit run, we see
our free message. If we select paidDebug and run our app again, we get our
paid message!

In addition to including addition sources in a flavor variant, we can place
flavor-specific configuration in our Gradle build file. Any configuration that
we can put in `defaultConfig { }` script block can also be placed in a flavor
configuration block. For example, let's say the paid version of our app
requires a new Android SDK. We can enforce that like so:

*/

//productFlavors {
//    paid {
//        minSdkVersion 23
//    }
//}


//dependencies {
//    compile fileTree(dir: 'libs', include: ['*.jar'])
//    compile 'com.android.support:appcompat-v7:24.1.1'
//}
