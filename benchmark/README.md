# Project Benchmarks

## Overview

This project uses the Java Microbenchmark Harness (JMH) framework to measure the performance of various mathematical and array operations. The benchmarks compare traditional loop-based implementations with vectorized implementations using the Java Vector API. Additionally, some benchmarks compare the impact of the SuperWord optimization.

## Setup

The toolset used in this project in consistent throughout all benchmarks and its specs are as described in the following sections.

### Toolset

- **Benchmark Tool:** [JMH](https://openjdk.java.net/projects/code-tools/jmh/)
- **JMH Version:** 1.36
- **JMH Mode:** Average Time
- **JMH Time Unit:** Nanoseconds

### Annotations

- `@State(Scope.Thread)`: Indicates that the benchmark state is maintained per thread.
- `@BenchmarkMode(Mode.AverageTime)`: Specifies that the benchmark measures the average time taken by the methods.
- `@OutputTimeUnit(TimeUnit.NANOSECONDS)`: Sets the time unit for the benchmark results.
- `@Fork`: Configures the JVM options for the benchmark runs.

### Fields and Parameters

- Fields like `matrixSize`, `matrix`, `kernel`, and `result` are used to store the input data and results for the benchmarks.
- `@Param`: Allows parameterization of the benchmarks to run with different input sizes.

### Benchmark Methods

- Methods annotated with `@Benchmark` contain the code to be benchmarked. These methods perform operations like _dot product_, _matrix multiplication_, etc., using both traditional loops and vectorized operations.

### Setup Method

- `@Setup(Level.Trial)`: Initializes the input data before the benchmark runs.

### Main Method

- Configures and runs the benchmarks using JMH.

## Benchmarks

The benchmarks in this project examine the performance of various mathematical and array operations, comparing traditional loop-based implementations with vectorized implementations using the Java Vector API. Additionally, some benchmarks compare the impact of the SuperWord optimization.

1. **ArrayStats**:
   - Benchmarks statistical operations on arrays using traditional loops vs. vectorized operations.

2. **ArrayStatsNoSuperWord**:
   - Similar to `ArrayStats`, but without the SuperWord optimization.

3. **ComplexExpression**:
   - Benchmarks the evaluation of complex mathematical expressions using traditional loops vs. vectorized operations.

4. **ComplexExpressionNoSuperWord**:
   - Similar to `ComplexExpression`, but without the SuperWord optimization.

5. **DotProduct**:
   - Benchmarks the calculation of the dot product of two vectors using traditional loops vs. vectorized operations.

6. **DotProductNoSuperWord**:
   - Similar to `DotProduct`, but without the SuperWord optimization.

7. **ElementWiseMultiplication**:
   - Benchmarks element-wise multiplication of two arrays using traditional loops vs. vectorized operations.
   
8. **ElementWiseMultiplicationNoSuperWord**:
    - Similar to `ElementWiseMultiplication`, but without the SuperWord optimization.

9. **MatrixMultiplication**:
    - Benchmarks matrix multiplication using traditional loops vs. vectorized operations.

10. **MatrixMultiplicationNoSuperWord**:
    - Similar to `MatrixMultiplication`, but without the SuperWord optimization.

11. **SimpleSum**:
    - Benchmarks summing all elements in an array using traditional loops vs. vectorized operations.

12. **SimpleSumNoSuperWord**:
    - Similar to `SimpleSum`, but without the SuperWord optimization.

13. **VectorAddition**:
    - Benchmarks adding two vectors element-wise using traditional loops vs. vectorized operations.

14. **VectorAdditionNoSuperWord**:
    - Similar to `VectorAddition`, but without the SuperWord optimization.

15. **Sorting**:
    - Benchmarks sorting an array using traditional loops vs. vectorized operations.

16. **SortingNoSuperWord**:
    - Similar to `Sorting`, but without the SuperWord optimization.

_NOTE_:
- _SuperWord optimization enhances performance by leveraging SIMD instructions to process multiple data elements in parallel. This results in significant performance gains for operations that can be vectorized, as observed in the benchmark results for operations like dot product, element-wise multiplication, and matrix multiplication. However, the effectiveness of this optimization can vary depending on the complexity and nature of the operations._

## Results

Below is a list of benchmark runs. Each benchmark run targets specific hardware and setup, as detailed in the dedicated subfolders for each run:
- [14/09/2024 - MacBook Air M2](20240914-macbook-air-m2/README.md)
- [18/09/2024 - MacBook Pro M1](20240918-macbook-pro-m1/README.md)
- [20/09/2024 - Dell Precision 7530](20240920-dell-precision-7530/README.md)

