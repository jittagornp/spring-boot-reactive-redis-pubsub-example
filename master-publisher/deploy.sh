#!/bin/bash
rm -rf target

#build source code (.jar file)
docker run --rm -v $(pwd):/app -v /root/.m2:/root/.m2 maven:3.6.2-jdk-11 mvn install -f /app/pom.xml

# remove container and images
docker stop master-app || true
docker rm master-app || true
docker rmi master-app || true

# build docker image
docker build -t master-app .

# run container
docker run -d --name=master-app -p 80:8080 --restart=always --link=redis-server master-app
