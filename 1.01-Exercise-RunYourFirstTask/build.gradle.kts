/*

Welcome to the first exercise in ud867! Have fun, and remember that you can
always check out the solution.gradle file for help!

In this simple Gradle build script we have defined a single task named
"hello". As you can see, the task's action simply prints the string "Hello
World" to the standard output.

Since we haven't installed Gradle yet, we'll execute this task using the
Gradle wrapper. The wrapper is a script that will download and install a
specified version of Gradle.

Remember that you can always look at the solution.gradle file for help!

Challenges:
  1. Find the solution.gradle file in this directory.
  2. Use the Gradle wrapper to execute the task "hello".
  3. Modify the action of this task so it instead prints your name.
  4. Figure out my favorite type of candy.

*/

tasks {
    register("hello") {
        group = "Our demo"
        description = "Hey student! Run this one :D"
        doLast {
            println("Hello world!")
        }
    }
}
