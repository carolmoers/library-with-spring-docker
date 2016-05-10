FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD app.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Dfile.encoding=UTF-8","-jar","/app.jar"]