/*

Copying files in Gradle is simple. We start by simply declaring a new task and
specify the type as "Copy".

*/

//task copyTask(type: Copy)
task("copyTask", Copy::class) {}


/*

Of course, this task won't actually do anything because we haven't told it
what file we would like copied and to where. The simplest example is simply to
copy the contents of one folder into another. We use the Copy task's "from"
method to add sources and the "into" method to specify the destination. This
copy task will copy the contents of the "images" directory into the "build"
directory.

*/

//task copyImages(type: Copy) {
//    from 'images'
//    into 'build'
//}
task("copyImages", Copy::class) {
    from("images")
    into("build")
}


/*

We can specify files to include or exclude. Our filters can use wildcards,
allowing us to do things like include all files that match a certain pattern
or have a particular file extension. This combination of source, destination,
inclusions, and exclusions is called a CopySpec. Let configure our task to
only include JPEG images by calling the "include" method and passing a file
pattern.

*/

//task copyJpegs(type: Copy) {
//    from 'images'
//    include '*.jpg'
//    into 'build'
//}
task("copyJpegs", Copy::class) {
    from("images")
    include("*.jpg")
    into("build")
}

/*

We can also configure a single Copy task to copy from multiple sources.
CopySpecs can be hierarchical, which is particularly useful when we want to
include certain files in a subfolder or exclude files from another.

Let's configure a Copy task which copies all JPEGs into one folder and GIFs
into another. We define two child CopySpecs, one  to include only JPEG files
and the other to include GIFs. We also specify the folder we want to copy
these files to. These folders will be created as subfolders under the root
copy destination. The result being that JPEGs will be copied to "build/jpeg"
and all .gif files will be copied to "build/gif".

*/

//task copyImageFolders(type: Copy) {
//    from('images') {
//        include '*.jpg'
//        into 'jpeg'
//    }
//
//    from('images') {
//        include '*.gif'
//        into 'gif'
//    }
//
//    into 'build'
//}

task("copyImageFolders", Copy::class) {
    from("images") {
        include("*.jpg")
        into("jpeg")
    }

    from("images") {
        include("*.gif")
        into("gif")
    }

    into("build")
}

/*

Gradle provides task types for creating archives like Zip or Tar files.
Archive tasks are nearly identical to Copy tasks, except instead of specifying
a destination directory, we specify an archive name. Let's Zip up all files in
our "images" directory. We use the Zip task's "baseName" and "destinationDir"
properties to tell Gradle what to name the archive and where to create it.
Note that the "destinationDir" property takes a Java File object. Luckily the
Gradle Project interface provides a convenience method for creating files.

*/

//task zipImages(type: Zip) {
//    baseName = 'images'
//    destinationDir = file('build')
//    from 'images'
//}

task("zipImages", Zip::class) {
    archiveName = "images.zip"
    destinationDir = file("build")
    from("images")
}

/*

We can do similar things with archive tasks and child CopySpecs. We can create
an archive which puts JPEGs and GIFs in their own directories inside the
archive. The only difference from our Copy task example is that we specify the
archive name and destination.

*/

//task zipImageFolders(type: Zip) {
//    baseName = 'images'
//    destinationDir = file('build')
//
//    from('images') {
//        include '*.jpg'
//        into 'jpeg'
//    }
//
//    from('images') {
//        include '*.gif'
//        into 'gif'
//    }
//}

task("zipImageFolders", Zip::class) {
    archiveName = "images.zip"
    destinationDir = file("build")

    from("images") {
        include("*.jpg")
        into("jpeg")
    }

    from("images") {
        include("*.gif")
        into("gif")
    }
}

/*

Sometimes we want to delete files during out builds. Usually to clean up
previous build outputs. We can use the Delete task to delete files or folders
in our project. Let's create a task that deletes the "build" folder.

*/

//task deleteBuild(type: Delete) {
//    delete 'build'
//}

task("deleteBuild", Delete::class) {
    delete("build")
}
