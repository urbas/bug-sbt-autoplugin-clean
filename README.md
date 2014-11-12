This project reproduces a potential SBT bug. Indicated by failing tests: [![Build Status](https://travis-ci.org/urbas/bug-sbt-autoplugin-clean.svg)](https://travis-ci.org/urbas/bug-sbt-autoplugin-clean)

__Setup__:

- An auto plugin generates a file. It adds this file to the `cleanFiles` list (see [source code](src/main/scala/si/urbas/sbt/CleanAutoPluginBug.scala#L22)).
 
- We add the plugin to the project (see [source code](src/sbt-test/autoplugin-must-clean/simple/build.sbt#L2))

__Test__ (see [test definition](src/sbt-test/autoplugin-must-clean/simple/test)):

1. We first invoke the plugin's file generation and verify that the file was created.

2. Finally, we invoke `clean` on the project.

__Expected behaviour__:

- The generated file should be deleted.

__Observed behaviour__:

- The file is not deleted.
