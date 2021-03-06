/*
    In this series of exercies you'll be configuring tasks to copy and delete
    files as well as build archives. This example contains some sample files 
    that you'll be using to complete the exercises below.

    Exercises:

    1. Create a task named "copyWeb". This task should perform the following:
        a) Copy files from "src/web" to a folder "build/web".
        b) Copy all .txt files from "src/docs" to folder "build/web/help".

    2. Create a task named "bundleWeb". This task should perform the following:
        a) Create a zip file located in the "build" folder named "web.zip".
        b) Include all the files copied by the "copyWeb" task except the
        "images" directory.

    3. Create a task named "unpackBundle". This task should perform the following:
        a) Expand the zip file created by the "bundleWeb" task.
        b) Copy the contents to a folder "build/exploded".

    HINT: There isn't an UnZip task, so what task type do you need? You're kinda copying files so...
    HINT: https://docs.gradle.org/current/dsl/org.gradle.api.Project.html#org.gradle.api.Project:zipTree(java.lang.Object)

    4. Create a task named "deleteHelp". This task should perform the following:
        a) Delete the "help" folder created by the "copyWeb" task.
*/

task("copyWeb", Copy::class) {
    from("src/web") {
        into("web")
    }

    from("src/docs") {
        include("*.txt")
        into("web/help")
    }
    into("build")

}

task("bundleWeb", Zip::class) {
    mustRunAfter("delete")
    archiveFileName.set("web.zip")
    destinationDirectory.set(file("build"))

    from("src/web") {
        into("web")
        exclude("images/")
    }

    from("src/docs") {
        include("*.txt")
        into("web/help")
    }

}

task("unpackBundle", Copy::class) {
    dependsOn("delete", "bundleWeb")
    from(zipTree("build/web.zip"))
    into("build")
    doLast {
        rename("build/web", "build/exploded")
    }

}

task("delete", Delete::class) {
    delete("build")
}