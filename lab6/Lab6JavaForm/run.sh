#!/bin/bash
# Run the Lab 6 Software Testing Application

echo "Starting Lab 6 - Software Testing Application..."
echo "Make sure MySQL server is running and lab6_db database exists!"
echo ""

cd "$(dirname "$0")"

# Check if compiled
if [ ! -d "target/classes" ]; then
    echo "Compiling project..."
    mvn clean compile
fi

# Run the application
mvn exec:java -Dexec.mainClass="org.example.Main"
