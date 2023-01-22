#!/usr/bin/env sh
./gradlew clean :bootJar

docker build --force-rm -t ${IMG_NAME:-domino_application} .
