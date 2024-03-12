#!/bin/sh

./mvnw clean package
docker build -t thecatapi .
docker run -p 8080:8080 thecatapi