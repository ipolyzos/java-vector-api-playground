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
