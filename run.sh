#!/bin/bash

./gradlew clean build -x test --no-daemon

./gradlew run -q --args="INPUT_FILE=sample_input/sample_input_one.txt"