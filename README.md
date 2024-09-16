# Java Vector API Playground

The aim of this project is to provide a test environment for experimenting with the Java [Vector API](https://openjdk.org/jeps/460) and simplify the process of running tests and contacting benchmarks. In addition to the benchmarks and tests included in this repository, our goal is to compile documentation and links to key resources that support the efficient and optimal use of the API. We also aim to maintain a record and a library of these valuable sources for future reference.
### Vector API

The primary goals of the [Vector API](https://openjdk.org/jeps/460) are to provide a platform-independent interface that allows for efficient implementation across various CPU architectures, such as [x64](https://en.wikipedia.org/wiki/X86-64) and [AArch64](https://en.wikipedia.org/wiki/AArch64), while ensuring consistent runtime compilation and performance. This reliability is crucial for developers to confidently utilize vector operations, with the expectation that they will closely align with hardware vector instructions, such as [Streaming SIMD Extensions (SSE)](https://en.wikipedia.org/wiki/Streaming_SIMD_Extensions) and [Advanced Vector Extensions (AVX)](https://en.wikipedia.org/wiki/Advanced_Vector_Extensions) on x64, as well as [NEON](https://en.wikipedia.org/wiki/ARM_architecture#Advanced_SIMD_(NEON)) and [SVE](https://en.wikipedia.org/wiki/Scalable_Vector_Extension) on AArch64.

The Vector API is designed in such a way to offer developers a straightforward and efficient means of expressing vector computations, which can be compiled at runtime into optimized vector instructions on compatible CPU architectures. This approach enables significantly better performance than traditional scalar computations.

The [latest update](https://openjdk.java.net/jeps/460), proposed for [JDK 22](https://openjdk.org/projects/jdk/22/), introduces _minor improvements_ and _bug fixes_, most notably expanding support for vector access to heap MemorySegments backed by arrays of any primitive element type. This marks a substantial enhancement over the previous limitation, which only supported byte arrays, broadening the API's versatility and performance potential.

## Project Structure

- **src/main/java/main**: Contains the main Java source files for the benchmarks.
- **pom.xml**: Maven configuration file.
- **Makefile**: Makefile to automate the build process and run benchmarks.
- **results**: Directory to store benchmark results 


*NOTE:* 

_Please note that the `results` directory is ignored from git as it is auto-generated, also lost with cleanup)._

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
- ArrayStatsNoSuperWord: ```$ make run-array-stats-no-super-word```
- ComplexExpression: ```$ make run-complex-expression```
- ComplexExpressionNoSuperWord: ```$ make run-complex-expression-no-super-word```
- DotProduct: ```$ make run-dot-product```
- DotProductNoSuperWord: ```$ make run-dot-product-no-super-word```
- ElementWiseMultiplication: ```$ make run-element-wise-multiplication```
- ElementWiseMultiplicationNoSuperWord: ```$ make run-element-wise-multiplication-no-super-word```
- MatrixMultiplication: ```$ make run-matrix-multiplication```
- MatrixMultiplicationNoSuperWord: ```$ make run-matrix-multiplication-no-super-word```
- SimpleSum: ```$ make run-simple-sum```
- SimpleSumNoSuperWord: ```$make run-simple-sum-no-super-word```
- DotProduct: ```$ make run-dot-product```
- DotProductNoSuperWord: ```$ make run-dot-product-no-super-word```
- MatrixMultiplication: ```$ make run-matrix-multiplication```
- MatrixMultiplicationNoSuperWord: ```$ make run-matrix-multiplication-no-super-word```
- All Benchmarks: ```$ make run-all```

## References

- [Java Vector API - JEP-338](https://openjdk.java.net/jeps/338) - JEP 338: Vector API (Incubator, JDK 16) 
- [Java Vector API - JEP-414](https://openjdk.java.net/jeps/414) - JEP 414: Vector API (Second Incubator, JDK 17)
- [Java Vector API - JEP-417](https://openjdk.java.net/jeps/417) - JEP 417: Vector API (Third Incubator, JDK 18)
- [Java Vector API - JEP-426](https://openjdk.java.net/jeps/426) - JEP 426: Vector API (Fourth Incubator, JDK 19)
- [Java Vector API - JEP-438](https://openjdk.java.net/jeps/438) - JEP 438: Vector API (Fifth Incubator, JDK 20)
- [Java Vector API - JEP-448](https://openjdk.java.net/jeps/448) - JEP 448: Vector API (Sixth Incubator, JDK 21)
- [Java Vector API - JEP-460](https://openjdk.java.net/jeps/460) - JEP 460: Vector API (Seventh Incubator, JDK 22)
- [Java Vector API (Incubator) Documentation](https://download.java.net/java/early_access/jdk17/docs/api/jdk.incubator.vector/module-summary.html)
- [Java Vector API Documentation](https://download.java.net/java/early_access/jdk17/docs/api/java.base/java/util/vector/package-summary.html)
- [Java Vector API: A New Era of Vectorization in Java](https://www.baeldung.com/java-vector-api) by [Baeldung](https://www.baeldung.com/)
- [Java Vector API on AArch64](https://community.arm.com/arm-community-blogs/b/high-performance-computing-blog/posts/java-vector-api-on-aarch64)
- [Java’s new Vector API: How fast is it? — Part 1](https://medium.com/@tomerr90/javas-new-vector-api-how-fast-is-it-part-1-1b4c2b573610) by [Tomer Zeltzer](https://github.com/tomerr90) 

## License

This project is licensed under the _MIT License_ - see the [LICENSE](LICENSE) file for details.