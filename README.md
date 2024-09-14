# Java Vector API Experiments

The goal of this project is to offer a testbed for experimentation with the Java Vector API and make it easy to run tests and benchmarks. It was initiated as a clone from the work presented in [Java’s new Vector API: How fast is it? — Part 1](https://medium.com/@tomerr90/javas-new-vector-api-how-fast-is-it-part-1-1b4c2b573610) by [Tomer Zeltzer](https://github.com/tomerr90) and further augmented to serve as a generic playground for experimentation and learning purposes.

## Project Structure

- **src/main/java/main**: Contains the main Java source files for the benchmarks.
- **pom.xml**: Maven configuration file.
- **Makefile**: Makefile to automate the build process and run benchmarks.
- **results**: Directory to store benchmark results 


*NOTE:* 

_Please note that the `ressults` directory is ignored from git as it is auto-generated, also lost with cleanup)._

## Prerequisites

- Java 17 or later (with preview features enabled)
- Maven
- Make

## Setup

To set up the project, run:

```sh
$ make setup
```

## Compile

To compile the project, run:

```sh
$ make compile
```

## Package

To package the project, run:

```sh
$ make package
```

## Running Benchmarks

To run the benchmarks, use the following commands:  
- ArrayStats: ```$ make run-array-stats```
- ComplexExpression: ```$ make run-complex-expression```
- ComplexExpressionNoSuperWord: ```$ make run-complex-expression-no-super-word```
- SimpleSum: ```$ make run-simple-sum```
- SimpleSumNoSuperWord: ```$make run-simple-sum-no-super-word```
- DotProduct: ```$ make run-dot-product```
- All Benchmarks: ```$ make run-all```

## License

This project is licensed under the _MIT License_ - see the [LICENSE](LICENSE) file for details.