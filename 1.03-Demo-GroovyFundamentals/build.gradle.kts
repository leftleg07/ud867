/*

Gradle build scripts are written in Groovy. Groovy is a language that runs on
the JVM that fills a hole for Java developers who need a scripting language.
It's terse, expressive, interoperates extremely well with Java, and has some
special features that make it ideally suited for creating domain specific
languages.

While we don't need to know a ton of Groovy to write Gradle build scripts, it
helps a lot to experiment a bit with the basics. Gradle provides its own
Groovy distribution, so we don't even need to install Groovy to get started.
We can just put our Groovy code in a build.gradle file, and then ask Gradle to
do anything that requires reading the build script.

We'll just declare a task called `groovy` that doesn't do anything. To run
this script, just ask Gradle to run the `groovy` task using

    $ gradle groovy

If you're using Sublime Text, you can turn on Groovy syntax coloring by
selecting View > Syntax > Open all with current extension as... > Groovy

*/

tasks {
    register("groovy") {}
}

println("Hello Groovy!")

/*

Most valid Java is also valid Groovy, and we can interoperate with Java, as
well as access the standard library. Let's make a Java class.

*/

class JavaGreeter {
    fun sayHello() {
        println("Hello Java")
    }
}

val greeter = JavaGreeter()
greeter.sayHello()

/*

Groovy is dynamically typed, which means type checking happens at runtime.
That also means you don't need to declare the types of variables.

*/

val foo = 6.5

/*

Groovy makes is super easy to build up strings using string interpolation.
A variable name prefaced with a dollar sign will have the appropriate value
inserted.

*/

println("foo has value: $foo")

/*

We can also surround any Groovy code with a dollar sign and curly braces.

*/

println("Let's do some math. 5 + 6 = ${5 + 6}")

/*

We can reassign a variable to a different type, and we can also inspect the
type of a variable using `foo.class`.

*/

val foo2 = "a string"
println("foo is now of type: ${foo2::class}  and has value: $foo2")

/*

The `println` keyword is just a shortcut for `System.out.println`, but you've
probably noticed that we're not using any parentheses, and there's not a
semicolon in sight. The latter are always optional, and parentheses can be
omitted whenever a function is called with at least one argument, and the
assignment of arguments to function calls is unambiguous.

These syntactic features are part of what make Groovy such a good choice for a
domain specific language. Let's define a function.

*/

fun doubleIt(n: Int) = n + n // Note we don't need a return statement


/*

Note that we don't need to specify the type of the arguments, nor the return
type. We don't even need to supply a return statement. The last expression in
the block is returned. Let's give it a try.

*/

val foo3 = 5
println("doubleIt($foo3) = ${doubleIt(foo3)}")
