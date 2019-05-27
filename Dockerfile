# FROM java:8
# 
# # Install maven
# RUN apt-get update
# RUN apt-get install -y maven

FROM maven:3-jdk-8

WORKDIR /app

ADD lib /app/lib
# Install the local jar as a maven dependency
RUN mvn install:install-file -Dfile=/app/lib/esdk_fc_neadp_2.1.00_native_java.jar -DgroupId=com.com.huawei.esdk -DartifactId=fusioncompute -Dversion=2.1.0 -Dpackaging=jar
RUN mvn install:install-file -Dfile=/app/lib/esdk_fc_neadp_2.1.00_native_java.zip -DgroupId=com.com.huawei.esdk -DartifactId=fusioncompute -Dversion=2.1.0 -Dpackaging=jar -Dclassifier=sources

# Prepare by downloading dependencies
ADD pom.xml /app/pom.xml
RUN ["mvn", "dependency:resolve", "dependency:resolve-plugins"]

# get all the downloads out of the way
RUN mvn verify clean --fail-never

# Adding source, compile and package into a fat jar
ADD src /app/src
RUN ["mvn", "clean", "package"]

# http://goinbigdata.com/docker-run-vs-cmd-vs-entrypoint/
# https://github.com/tianon/docker-brew-ubuntu-core/blob/010bf9649b1d10e2c34b159a9a9b338d0fdd4939/bionic/Dockerfile
# https://stackoverflow.com/questions/40122152/how-to-remove-entrypoint-from-parent-image-on-dockerfile
ENTRYPOINT []

EXPOSE 8080
CMD mvn spring-boot:run
