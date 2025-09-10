#!/bin/bash
# Compile script for Simple level programs

echo "Compiling Simple level Java programs..."
cd src
javac *.java
echo "Compilation complete! You can now run:"
echo "  java HelloWorld"
echo "  java Variables"
echo "  java BasicCalculator"
echo "  java ConditionalStatements"
echo "  java Loops"