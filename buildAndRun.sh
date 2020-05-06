#!/bin/sh
mvn clean package && docker build -t dk.logb/currency .
docker rm -f currency || true && docker run -d -p 8080:8080 -p 4848:4848 --name currency dk.logb/currency 
