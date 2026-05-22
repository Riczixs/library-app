#!/bin/bash
echo "F start"
services=("lab-author" "eureka" "lab-book2" "lab-gateway")
for serv in "${services[@]}"; do
    cd $serv
    ./mvnw package -DskipTests
    chmod 777 target
    docker build -t $serv .
    cd ..
done

docker images > images.txt
if grep -o "lab-author:latest" images.txt && grep -o "lab-gateway:latest" images.txt && grep -o "eureka:latest" images.txt && grep -o "lab-book2:latest" images.txt
then
    docker compose up
else
    echo "Build failed"
fi