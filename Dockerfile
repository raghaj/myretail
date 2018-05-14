FROM openjdk:8-jre-alpine
COPY ./target/product-price-service-1.0.0-SNAPSHOT.jar /usr/src/myretail/
WORKDIR /usr/src/myretail
CMD ["java", "-jar", "product-price-service-1.0.0-SNAPSHOT.jar"]