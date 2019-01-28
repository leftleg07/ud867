tasks {
    register("stringsAndTypes") {
        doLast {
            // TODO: Run `$ gradle sAT`
            println("Nice work abbreviating the task name")

            // TODO: Create a variable named foo and assign it the value 4.2
            val foo = 4.2

            // TODO: Print the value and class of foo
            println("The foo value is $foo and class is ${foo::class}")

            // TODO: Use string interpolation to print the square root of 127
            // HINT: http://docs.oracle.com/javase/7/docs/api/java/lang/Math.html
            val squareRoot = Math.sqrt(127.toDouble()).toString()

            // TODO: Assign the current date to foo and print it, along with its type
            // HINT:
            // http://docs.oracle.com/javase/7/docs/api/java/util/package-summary.html
            val current = java.time.LocalDateTime.now()

            println("Current Date and Time is: $current")

            // TODO: Use the `substring` method to extract my name from this string
            val hello = "Hello, Jeremy."
            val myName = hello.substringAfter(",").trim()
            println("My name is $myName")

            // TODO: Use `toUpperCase` to capitalize and print my name}
            println("My name is ${myName.toUpperCase()}")
        }
    }
    register("closures") {
        doLast {
            // TODO: Declare a closure that takes two arguments and adds them together
            // HINT: http://www.groovy-lang.org/closures.html
            val addTwo = { x: Int, y: Int -> x + y }

            // TODO: Call your closure with arguments 17 and 25, and print the result
            // Beware that something like `println addTwo 17, 25` is ambiguous
            println(addTwo(17, 15))
        }
    }
    register("lists") {
        doLast {
            // TODO: Declare a list containing 5 of your favorite candies
            // HINT: Try searching for "groovy list literal"
            val candies = arrayOf("Skittles", "Jolly Rancher", "Milk Duds", "Baby Ruth", "Starburst")

            // TODO: Create a new list of your candies in all caps
            // HINT: http://mrhaki.blogspot.ca/2010/05/groovy-goodness-use-collect-with.html
            val allCapsCandies = candies.map { it.toUpperCase() }

            // TODO: Print each capital candy
            allCapsCandies.forEach(::println)
        }
    }
}