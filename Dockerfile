FROM openjdk:8
COPY ./out/production/swarch_java/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java"]