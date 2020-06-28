#!/bin/bash
rm -rf target

#build source code (.jar file)
docker run --rm -v $(pwd):/app -v /root/.m2:/root/.m2 maven:3.6.2-jdk-11 mvn install -f /app/pom.xml

# remove container and images
docker stop slave-app-01 || true
docker stop slave-app-02 || true
docker stop slave-app-03 || true
docker rm slave-app-01 || true
docker rm slave-app-02 || true
docker rm slave-app-03 || true
docker rmi slave-app || true

# build docker image
docker build -t slave-app .

# run container
docker run -d --name=slave-app-01 -p 8081:8081 --restart=always --link=redis-server slave-app
docker run -d --name=slave-app-02 -p 8082:8081 --restart=always --link=redis-server slave-app
docker run -d --name=slave-app-03 -p 8083:8081 --restart=always --link=redis-server slave-app
