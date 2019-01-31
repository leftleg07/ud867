/*

Gradle provides built-in support for testing your applications. Core support
is provided for JUnit and TestNG testing frameworks. To get started running
unit tests all you need to do is place your tests in the 'src/test/java'
directory when using the Java plugin. You can, of course, change the location
of your test code by configuring the 'test' source set. Gradle will
automatically compile and run any appropriately annotated tests that are found
in the 'test' source set. The only things we have to manually configure are
our test dependencies. In this example we're using JUnit as our testing
framework so we add a 'junit' dependency to the 'testCompile' configuration.

Running our tests is easy, just run the 'test' task.

    $ gradle test

You'll notice Gradle performs all the required steps to run our tests. It
first compiles our production code, followed by our test code, and then runs
our tests. In this case, the build was successful, indicating that all of our
tests passed.

Gradle also provides detailed reports on our test execution. These reports are
placed in the 'build/reports' directory. Let's take a look at one of these
reports. On Mac you can use:

    $ open build/reports/tests/index.html

In this case we can see that we have 1 test and that it was successful. Of
course in a real project we would likely have a number of tests.

In case of a test failure, our build will fail with a message indicating which
test or tests failed. We can then take a look at the detailed report to try
and troubleshoot while our test is failing. In this case you can see the
failed test is identified and a stacktrace is provided for debugging purposes.

*/

plugins {java}

repositories {
    mavenCentral()
}

dependencies {
    testCompile("junit:junit:4.12")
}
