FROM adoptopenjdk:8-jre-hotspot

COPY open-data-smn-dev.yml /open-data-smn.yml
COPY target/open-data-smn-1.5.1.jar /open-data-smn.jar

CMD ["/opt/java/openjdk/bin/java", "-jar", "/open-data-smn.jar", "server", "/open-data-smn.yml"]
