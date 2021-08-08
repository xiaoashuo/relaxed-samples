FROM anapsix/alpine-java:8_server-jre_unlimited
MAINTAINER Yakir <xiaoxiai@vip.qq.com>
ENV TZ=Asia/Shanghai
ENV PROJECT_NAME relaxed-samples-codegen-backend
ENV APP_VERSION 1.0.0-SNAPSHOT
ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

RUN mkdir /app

COPY $PROJECT_NAME-$APP_VERSION.jar /app/app.jar
#CMD sleep 60;java -Djava.security.egd=file:/dev/./urandom -jar $PROJECT_NAME-$APP_VERSION.jar
ENTRYPOINT ["dockerize", "-timeout", "5m", "-wait", "tcp://172.81.209.80:3306", "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]

EXPOSE 80