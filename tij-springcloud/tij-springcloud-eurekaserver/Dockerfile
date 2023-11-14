FROM openjdk:8u201-jdk-alpine3.9

MAINTAINER wbm<1584558751@qq.com>

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

VOLUME /tmp

ADD target/tij-springcloud-eurekaserver-*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 8761