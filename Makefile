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
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.ArrayStats > results/ArrayStats.txt

# Run the ComplexExpression
run-complex-expression: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.ComplexExpression > results/ComplexExpression.txt

# Run the ComplexExpressionNoSuperWord
run-complex-expression-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.ComplexExpressionNoSuperWord > results/ComplexExpressionNoSuperWord.txt

# Run the SimpleSum
run-simple-sum: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.SimpleSum > results/SimpleSum.txt

# Run the SimpleSumNoSuperWord
run-simple-sum-no-super-word: package
	java --enable-preview --add-modules=jdk.incubator.vector -cp target/vectors.jar main.SimpleSumNoSuperWord > results/SimpleSumNoSuperWord.txt

# Run all the programs
run-all: run-array-stats run-complex-expression run-complex-expression-no-super-word run-simple-sum run-simple-sum-no-super-word