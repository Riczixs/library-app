#!/bin/bash

makejars(){
    echo "F start"
    services=("lab-author" "eureka" "lab-book2" "lab-gateway")
    for serv in "${services[@]}"; do
        cd $serv
            ./mvnw package -DskipTests
            chmod 777 target
        cd ..
    done;
    if [[-e ${PWD}/lab-book2/*.jar] && [-e ${PWD}/lab-author/*.jar] && [-e ${PWD}/lab-gateway/*.jar] && [-e ${PWD}/eureka/*.jar]];
    then
        echo "Services built successfully!"
    fi
}
$(makejars)




#echo "${0%/*}"
