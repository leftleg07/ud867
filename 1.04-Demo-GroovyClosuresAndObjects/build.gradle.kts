/*

Groovy has another way to declare functions called closures. Closures have
two interesting features. First, they are just values that can be assigned to
a variable, just like a number or a string. Second, they can capture variables
from the scope in which they're declared.

*/

tasks {
    register("kotlin") {}
}


val foo = "One million dollars"
val myClosure = {
    println("Hello from a closure")
    println("The value of foo is $foo")
}

myClosure()
val bar = myClosure
val baz = bar
baz()

/*

Closures have a different notation for arguments.

*/

val doubleIt = { x: Int -> x + x }

/*

Groovy also allows for higher order functions. That is, functions that take
functions as arguments. Let's make a function that applies another function
twice.

*/

fun applyTwice(func: (Int) -> Int, arg: Int) = func(func(arg))


val foo2 = 5
val fooDoubledTwice = applyTwice(doubleIt, foo2)
println("Applying doubleIt twice to $foo2 equals $fooDoubledTwice")

/*

A language where functions are just objects that can be passed around is
said to have "first class functions". The implications of this style of
programming go quite deep and beyond the scope of this course. A search for
    "first class function" or "functional programming" will give you more
information.

        Groovy allows for very sophisticated list processing using closures. We can
declare a list using a literal.

*/

val myList = arrayOf("Gradle", "Groovy", "Android")

/*

We can execute a closure for each item in the list.

*/

val printItem = { item: String -> println("List item: $item") }
myList.forEach(printItem)

/*

We can make this notation much more compact by declaring the closure in-
line, and removing the parentheses. Also, if a closure accepts a single
argument, by default that argument is just called `it`.

*/

myList.forEach { println("Compactly printing each list item: $it") }

/*

Groovy has a simplified syntax for declaring classes. Note that these classes
are essentially to Java classes under the hood. Groovy automatically generates
getters and setters for class properties.

*/

class GroovyGreeter {
    var greeting = "Default greeting"
    fun printGreeting() {
        println("Greeting: $greeting")
    }
}

val myGroovyGreeter = GroovyGreeter()

myGroovyGreeter.printGreeting()
myGroovyGreeter.greeting = "My custom greeting"
myGroovyGreeter.printGreeting()


/*

Congrats on completing our whirlwind tour of Groovy! There are many
resources to help you learn more, including:

    http://learnxinyminutes.com/docs/groovy/
    http://www.groovy-lang.org/documentation.html

*/
