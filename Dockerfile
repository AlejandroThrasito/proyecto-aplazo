FROM openjdk:11
EXPOSE 8081
ADD ./target/proyecto-aplazo-1.0.0.jar   proyecto-aplazo.jar
ENTRYPOINT ["java","-jar","/proyecto-aplazo.jar"]