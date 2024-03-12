#!/bin/sh

./mvnw clean package
docker build -t tasks .
docker run -p 8080:8080 tasks