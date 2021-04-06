FROM openjdk:8-slim
WORKDIR /
COPY . .
CMD ["java", "-jar", "aqa-shop.jar" ]
EXPOSE 8080
