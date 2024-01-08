FROM openjdk:8u201-jdk-alpine3.9

MAINTAINER wbm<1584558751@qq.com>

ENV LANG=C.UTF-8 LC_ALL=C.UTF-8

VOLUME /tmp

ADD tij-springcloud-eurekaserver-*.jar tij-springcloud-eurekaserver.jar

ENTRYPOINT ["java","-jar","/tij-springcloud-eurekaserver.jar"]

EXPOSE 8761
