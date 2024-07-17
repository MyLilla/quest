FROM maven:3.9.8-amazoncorretto-21-al2023 AS MAVEN_BUILD
WORKDIR /app
COPY ./ ./
RUN mvn clean package

FROM tomcat:9.0.91-jdk21-corretto-al2
COPY --from=MAVEN_BUILD /app/target/Quest.war /usr/local/tomcat/webapps/
EXPOSE 8080
