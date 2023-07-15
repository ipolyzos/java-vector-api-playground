mvn clean package
java --enable-preview --add-modules=jdk.incubator.vector -cp vectors.jar main.SimpleSum > SimpleSum
java --enable-preview --add-modules=jdk.incubator.vector -cp vectors.jar main.SimpleSum > SimpleSumNoSuperWord
java --enable-preview --add-modules=jdk.incubator.vector -cp vectors.jar main.ComplexExpression > ComplexExpression
java --enable-preview --add-modules=jdk.incubator.vector -cp vectors.jar main.ComplexExpression > ComplexExpressionNoSuperWord
java --enable-preview --add-modules=jdk.incubator.vector -cp vectors.jar main.ArrayStats > ArrayStats
