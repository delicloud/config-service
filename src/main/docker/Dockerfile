FROM openjdk:8-jre

ADD *.war /app.war

EXPOSE 8888

CMD java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.war
