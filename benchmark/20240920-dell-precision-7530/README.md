# 20240914 - Dell Precision 7530 - Benchmark

## Machine Specifications

- **Model Name:** Dell Precision - 7530
- **Model Identifier:** Mac14,2
- **Model :** 158
- **Chip:** Intel(R) Core(TM) i9-8950HK CPU @ 2.90GHz
- **Total Number of Cores:** 12
- **Memory:** 64 GB

## Results

### [`ArrayStats.json`](/ArrayStats.json)

![Image for ArrayStats](ArrayStats01.png)
![Image for ArrayStats](ArrayStats02.png)

### [`ArrayStatsNoSuperWord.json`](/ArrayStatsNoSuperWord.json)

![Image for ArrayStatsNoSuperWord](ArrayStatsNoSuperWord01.png)
![Image for ArrayStatsNoSuperWord](ArrayStatsNoSuperWord02.png)

### [`ComplexExpression.json`](/ComplexExpression.json)

![Image for ComplexExpression](ComplexExpression01.png)
![Image for ComplexExpression](ComplexExpression02.png)

### [`ComplexExpressionNoSuperWord.json`](/ComplexExpressionNoSuperWord.json)

![Image for ComplexExpressionNoSuperWord](ComplexExpressionNoSuperWord01.png)
![Image for ComplexExpressionNoSuperWord](ComplexExpressionNoSuperWord02.png)

### [`DotProduct.json`](/DotProduct.json)

![Image for DotProduct](DotProduct01.png)
![Image for DotProduct](DotProduct02.png)

### [`DotProductNoSuperWord.json`](/DotProductNoSuperWord.json)

![Image for DotProductNoSuperWord](DotProductNoSuperWord01.png)
![Image for DotProductNoSuperWord](DotProductNoSuperWord02.png)

### [`ElementWiseMultiplication.json`](/ElementWiseMultiplication.json)

![Image for ElementWiseMultiplication](ElementWiseMultiplication01.png)
![Image for ElementWiseMultiplication](ElementWiseMultiplication02.png)

### [`ElementWiseMultiplicationNoSuperWord.json`](/ElementWiseMultiplicationNoSuperWord.json)

![Image for ElementWiseMultiplicationNoSuperWord](ElementWiseMultiplicationNoSuperWord01.png)
![Image for ElementWiseMultiplicationNoSuperWord](ElementWiseMultiplicationNoSuperWord02.png)

### [`MatrixMultiplication.json`](/MatrixMultiplication.json)

![Image for MatrixMultiplication](MatrixMultiplication01.png)
![Image for MatrixMultiplication](MatrixMultiplication02.png)

### [`MatrixMultiplicationNoSuperWord.json`](/MatrixMultiplicationNoSuperWord.json)

![Image for MatrixMultiplicationNoSuperWord](MatrixMultiplicationNoSuperWord01.png)
![Image for MatrixMultiplicationNoSuperWord](MatrixMultiplicationNoSuperWord02.png)

### [`SimpleSum.json`](/SimpleSum.json)

![Image for SimpleSum](SimpleSum01.png)
![Image for SimpleSum](SimpleSum02.png)

### [`SimpleSumNoSuperWord.json`](/SimpleSumNoSuperWord.json)

![Image for SimpleSumNoSuperWord](SimpleSumNoSuperWord01.png)
![Image for SimpleSumNoSuperWord](SimpleSumNoSuperWord02.png)

### [`Sorting.json`](/Sorting.json)

![Image for Sorting](Sorting01.png)
![Image for Sorting](Sorting02.png)

### [`SortingNoSuperWord.json`](/SortingNoSuperWord.json)

![Image for SortingNoSuperWord](SortingNoSuperWord01.png)
![Image for SortingNoSuperWord](SortingNoSuperWord02.png)

### [`VectorAddition.json`](/VectorAddition.json)

![Image for VectorAddition](VectorAddition01.png)
![Image for VectorAddition](VectorAddition02.png)

### [`VectorAdditionNoSuperWord.json`](/VectorAdditionNoSuperWord.json)

![Image for VectorAdditionNoSuperWord](VectorAdditionNoSuperWord01.png)
![Image for VectorAdditionNoSuperWord](VectorAdditionNoSuperWord02.png)

## Analysis

The benchmarks were conducted on a Dell Precision 7530 equipped with an Intel(R) Core(TM) i9-8950HK CPU @ 2.90GHz. The results indicate that vectorized implementations generally provide significant performance improvements over traditional loop-based implementations across a variety of mathematical and array operations. The SuperWord optimization further enhances the performance of vectorized implementations in most scenarios.

### Key Observations

#### ArrayStats and ArrayStatsNoSuperWord
- **Performance Improvement**: Vectorized implementations show a marked improvement in performance.
- **SuperWord Optimization**: Provides additional gains.

#### ComplexExpression and ComplexExpressionNoSuperWord
- **Performance Improvement**: These benchmarks did not exhibit the same level of performance improvement with vectorization.
- **Reason**: Likely due to the complexity and nature of the operations involved.

#### DotProduct and DotProductNoSuperWord
- **Performance Improvement**: Significant performance gains were observed with vectorized implementations.
- **SuperWord Optimization**: Further enhances performance.

#### ElementWiseMultiplication and ElementWiseMultiplicationNoSuperWord
- **Performance Improvement**: Vectorized implementations outperformed traditional loops.
- **SuperWord Optimization**: Provides additional benefits.

#### MatrixMultiplication and MatrixMultiplicationNoSuperWord
- **Performance Improvement**: Vectorized implementations showed substantial performance improvements.
- **SuperWord Optimization**: Provides further enhancements.

#### SimpleSum and SimpleSumNoSuperWord
- **Performance Improvement**: These benchmarks did not show significant performance gains with vectorization.
- **Reason**: Similar to complex expressions, likely due to the simplicity of the operations.

#### Sorting and SortingNoSuperWord
- **Performance Improvement**: Vectorized sorting algorithms demonstrated improved performance over traditional sorting methods.
- **SuperWord Optimization**: Contributes to further gains.

#### VectorAddition and VectorAdditionNoSuperWord
- **Performance Improvement**: Vectorized implementations significantly outperformed traditional loops.
- **SuperWord Optimization**: Provides additional performance improvements.

### Summary
Overall, the results highlight the effectiveness of vectorization and the SuperWord optimization in enhancing performance for a wide range of operations, with some exceptions in more complex or simple summation tasks.