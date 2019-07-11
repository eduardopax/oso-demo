FROM openjdk:8u201-jre-alpine3.9


ADD /build/libs/pod-demo-1.0.0.jar /app.jar

ENV HOST LOCALHOST

EXPOSE 8080

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]