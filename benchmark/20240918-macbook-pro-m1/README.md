# 20240914 - MacBook Pro (M1) - Benchmark

## Machine Specifications

- **Model Name:** MacBook Pro
- **Model Identifier:** MacBookPro17,1
- **Model Number:** Z11D000KXD/A
- **Chip:** Apple M1
- **Total Number of Cores:** 8 (4 performance and 4 efficiency)
- **Memory:** 16 GB
- **System Firmware Version:** 10151.140.19
- **OS Loader Version:** 10151.140.19
- **Activation Lock Status:** Enabled

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

The benchmarks were conducted on a MacBook Pro equipped with an Apple M1 chip. The results indicate that vectorized implementations generally provide significant performance improvements over traditional loop-based implementations across a variety of mathematical and array operations. The SuperWord optimization further enhances the performance of vectorized implementations in most scenarios.

### Key Observations

1. **ArrayStats and ArrayStatsNoSuperWord**:
    - **Vectorized Implementations**: Show a marked improvement in performance.
    - **SuperWord Optimization**: Provides additional gains, making the operations faster.

2. **ComplexExpression and ComplexExpressionNoSuperWord**:
    - **Vectorized Implementations**: Did not exhibit the same level of performance improvement.
    - **Reason**: Likely due to the complexity and nature of the operations involved.

3. **DotProduct and DotProductNoSuperWord**:
    - **Vectorized Implementations**: Significant performance gains were observed.
    - **SuperWord Optimization**: Further enhances the performance, making the dot product calculations more efficient.

4. **ElementWiseMultiplication and ElementWiseMultiplicationNoSuperWord**:
    - **Vectorized Implementations**: Outperformed traditional loops.
    - **SuperWord Optimization**: Provides additional benefits, improving the speed of element-wise multiplications.

5. **MatrixMultiplication and MatrixMultiplicationNoSuperWord**:
    - **Vectorized Implementations**: Showed substantial performance improvements.
    - **SuperWord Optimization**: Further enhances the performance, making matrix multiplications faster.

6. **SimpleSum and SimpleSumNoSuperWord**:
    - **Vectorized Implementations**: Did not show significant performance gains.
    - **Reason**: Similar to complex expressions, the simple nature of the task might not benefit as much from vectorization.

7. **Sorting and SortingNoSuperWord**:
    - **Vectorized Implementations**: Demonstrated improved performance over traditional sorting methods.
    - **SuperWord Optimization**: Contributes to further gains, making sorting operations more efficient.

8. **VectorAddition and VectorAdditionNoSuperWord**:
    - **Vectorized Implementations**: Significantly outperformed traditional loops.
    - **SuperWord Optimization**: Provides additional performance improvements, making vector additions faster.

### Conclusion

Overall, the results highlight the effectiveness of vectorization and the SuperWord optimization in enhancing performance for a wide range of operations. However, some exceptions exist in more complex or simple summation tasks where the benefits of vectorization are less pronounced.