# Updated Cellular Automata

Now that I've taken a more advanced course on [Object-Oriented Design](https://course.ccs.neu.edu/cs3500/), I wanted to see how I would design [my original solution](https://github.com/rswernofsky/cellular-automata) differently to Problem 1 from [this assignment](https://course.ccs.neu.edu/cs2510a/assignment7.html) from [a previous course I took](https://course.ccs.neu.edu/cs2510a/index.html).

It models simple binary rule-based cellular automata, arranged in a line. The program starts with a single row of square cells whose states are either on or off. On every tick, a new row of children cells are generated from the previous row using a specified rule. Certain rules cause interesting patterns to emerge. 

## Design changes
* uses JUnit instead of `tester.jar` (testing library built by [my professor](https://www.khoury.northeastern.edu/people/benjamin-lerner/))
* uses Swing instead of `javalib.jar` (image library built by my professor)
* is now compartmentalized using MVC architecture
  * drawing uses the [adapter pattern](https://en.wikipedia.org/wiki/Adapter_pattern)
  * a combination of a main class and a Controller do the job of the `CAWorld`
* no longer having separate objects for `Cell`s with different rules: `Rule30Cell`, `InertCell`, etc objects don't take advantage of dynamic dispatch, which is one of the main advantages of representing types as objects. So for the sake of simplicity, I just let a cell's "rule" be a variable

## Notes for running
Interesting "rule"s to use: 30, 54, 60, 182

This program uses the arguments that the main method receives as input (`String[] args`). Set up a run configuration that just contains a number (in IntelliJ this is the box labeled "program arguments").