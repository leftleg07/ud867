/*

Different dependencies may be needed at different times in the build process.
Logically related dependencies are grouped into configurations. So far we've
been adding dependencies to the 'compile' configuration, but the Java plugin
creates other configurations as well, such as runtime, testCompile and
testRuntime. The Java plugin ensures that the specified dependencies are on
the classpath when the corresponding tasks are run.

Dependencies can be added to any of these configurations by simply using the
name of the configuration followed by a dependency notation.

*/

plugins { java }

repositories {
    mavenCentral()
}

dependencies {
    compile ("commons-logging:commons-logging:1.1.3")
    testCompile ("junit:junit:4.12")
}

/*

Here we have added a dependency to the 'testCompile' configuration. This
dependency will only be available from our test code.

Configurations can extend other configurations. For example, the 'testCompile'
configuration extends from the 'compile' configuration, which means that
'compile' dependencies are automatically included in 'testCompile'. We can
verify this by generating a dependency report.

    $ gradle dependencies

Here we can see that the 'compile' configuration contains only the 'commons-
logging' dependency, however, 'testCompile' contains both 'junit' and
'commons-logging'.

If you have a more advanced build, with dependencies that don't fit into a
configuration defined by the Java plugin, you can create a custom
configuration. Just add the name of your configuration to the `configurations`
script block. We can then assign dependencies to this configuration.

*/

val custom by configurations.creating {"custom"}

dependencies {
    custom ("com.google.guava:guava:18.0")
}

/*

We can run a dependency report to see that we have a new project configuration
named 'custom' with the 'guava' dependency.

    $ gradle dependencies

Configurations are really just fancy file collections and can be used anywhere
a file collection can be used, such as in Copy tasks. This is useful if we
want to download some dependencies from a remote repository and bundle them in
our project somehow.

*/

//task("copyDependencies", Copy::class) {
//    from (configurations.custom)
//    into ("build/libs")
//}
