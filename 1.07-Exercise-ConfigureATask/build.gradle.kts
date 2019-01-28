/*

It's time for you to create your first Gradle task. Be sure to try and run
your task after each exercise to ensure that your Gradle build script is
properly formatted.

Exercises:

1. Create an empty task definition and name your task "hello".
2. Give your task a description.
3. Add an action to your task which prints "Hello World!"

Hint: Take a look at the Gradle DSL Reference if you need help adding a
description.

Hint: Don't forget about the solution file!

https://docs.gradle.org/current/dsl/org.gradle.api.Task.html#org.gradle.api.Task:description

*/

task("hello").apply {
    // We can also set a group to organize tasks
    group = "Udacity"

    // 2. Set a description
    description = "This is my first Gradle task"

    // 3. Add a task action which prints to the console
    doLast {
        println("Hello World!")
    }
}