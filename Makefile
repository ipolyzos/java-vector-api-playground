# Create a simple Makefile to automate the build process of the project
# and to make it easier to run the benchmarks
#
# Author: Ioannis Polyzos <git@ipolyzos.com>

# Setup the project
setup:
	@mkdir -p results

# Clean the project using the maven build tool
clean:
	mvn clean

# Compile the program using the maven build tool
#
compile: setup
	mvn compile

# Package the program using the maven build tool
package: compile
	mvn package

# Run the ArrayStats
run-array-stats: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.ArrayStats

# Run the ComplexExpression
run-complex-expression: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.ComplexExpression

# Run the ComplexExpressionNoSuperWord
run-complex-expression-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.ComplexExpressionNoSuperWord

# Run the SimpleSum
run-simple-sum: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.SimpleSum

# Run the SimpleSumNoSuperWord
run-simple-sum-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.SimpleSumNoSuperWord

# Run the DotProduct
run-dot-product: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.DotProduct

# Run the DotProductNoSuperWord
run-dot-product-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.DotProductNoSuperWord

# Run the MatrixMultiplication
run-matrix-multiplication: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.MatrixMultiplication

run-matrix-multiplication-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.MatrixMultiplicationNoSuperWord

run-vector-addition: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.VectorAddition

run-vector-addition-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.VectorAdditionNoSuperWord

# Run all the programs
run-all: run-array-stats run-complex-expression run-complex-expression-no-super-word run-simple-sum run-simple-sum-no-super-word run-dot-product run-dot-product-no-super-word run-matrix-multiplication run-vector-addition run-vector-addition-no-super-word