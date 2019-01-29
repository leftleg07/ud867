/*

Now that we've configured our repositories, we can define dependencies on
artifacts contained in those repositories. Dependencies that are resolved from
repositories are referred to as 'external module dependencies'. Dependencies
are assigned to 'configurations'. We'll talk more about configuration in
detail later but for now you can simply consider them to be groups of related
dependencies.

*/

plugins { java }

repositories {
    jcenter()
}

dependencies {
    implementation("com.google.guava:guava:18.0")
}

/*

For the examples here we'll be adding dependencies to the
'compile' configuration which is added by the Java plugin. Dependencies are
configured in the `dependencies { }` script block. The syntax used is the name
of the configuration we want to add the dependency to, followed by a
dependency notation. External module dependencies are identified by their
group, name and version.

A Groovy map syntax can also be used to identify dependencies.

*/

dependencies {
    implementation(group = "com.google.guava", name = "guava", version = "18.0")
}

/*

In some cases we simply have files that we want to add as dependencies. File
dependencies are declared very similarly to managed dependencies, however,
instead of a dependency notation, we simply use a `FileCollection` or
`FileTree`. In this example, we are simply adding two JAR files as
dependencies by creating a `FileCollection`.

*/

dependencies {
    implementation(files("libs/foo.jar", "libs/bar.jar"))
}

/*

We can also use a `FileTree`, which allows us to do things like specify
filters. This is useful for including a number of files within a directory.

*/

dependencies {
    implementation(fileTree("dir" to "libs", "include" to "*.jar"))
}

/*

Gradle also supports project dependencies, which are dependencies to other
Gradle projects within a single multi-project build. We'll talk more about
multi-project builds and project dependencies in the next lesson.

*/
