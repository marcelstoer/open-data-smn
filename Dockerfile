FROM openjdk:8-jre-alpine

COPY open-data-smn-dev.yml /open-data-smn.yml
COPY target/open-data-smn-1.5.1.jar /open-data-smn.jar

CMD ["/usr/bin/java", "-jar", "/open-data-smn.jar", "server", "/open-data-smn.yml"]
