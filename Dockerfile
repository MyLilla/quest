FROM tomcat:9-jdk17-corretto

COPY ./target/quest-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
