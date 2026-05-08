FROM niceos/openjdk25:25.0.0
EXPOSE 8181
COPY target/spring-jenkins.jar spring-jenkins.jar
ENTRYPOINT [ "java","-jar","spring-jenkins.jar" ]