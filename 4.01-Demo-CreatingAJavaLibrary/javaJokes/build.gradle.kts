/*

We're just making a standard Java project, following all the default
conventions. That means our build.gradle is super simple:

*/

//apply plugin:"java"
plugins {java}

repositories {
    jcenter()
}

dependencies {
    testCompile("junit:junit:4.12")
}

/*

There is one additional wrinkle, however. Android doesn't yet fully support Java 8,
so any Java libraries we want to use on Android will need to be compiled with Java 7.
The Java plugin makes this very easy to configure. We just need the following
line:

*/

//sourceCompatibility = 1.7
java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

/*

We can now create our joke telling library. We'll create a file at

    javaJokes/src/main/java/com/udacity/gradle/jokes/Joker.java

With contents:

    package com.udacity.gradle.jokes;

    public class Joker {
        public String getJoke(){
            return "This is totally a funny joke";
        }
    }

Now if we want to, we can navigate to the javaJokes directory and run Gradle
tasks like usual. If we also add

    javaJokes/src/test/java/com/udacity/gradle/jokes/test/JokerTest.java

With contents:

    package com.udacity.gradle.jokes.test;

    import com.udacity.gradle.jokes.Joker;
    import org.junit.Test;

    public class JokerTest {
        @Test
        public void test() {
            Joker joker = new Joker();
            assert joker.getJoke().length() != 0;
        }
    }

We can then test our library in isolation using

    $ gradle test

However, our app project doesn't yet know anything about our
library. What we really need to do is declare a compile dependency on the
output of this project. To do that, we need to add this Gradle project to the
same multi-project build as the app. Let's head over to the settings.gradle
file in the project root.

*/