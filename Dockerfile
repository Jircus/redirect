FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD com.mediasol.ceres.redirect/target/com.mediasol.ceres.redirect.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Dspring.profiles.active=cloud -Xmx500M"
EXPOSE 7777
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -jar /app.jar" ]
