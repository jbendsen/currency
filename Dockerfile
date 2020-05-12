FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
USER root
COPY pom.xml /tmp/
COPY src /tmp/src/
COPY generated /tmp/generated/
WORKDIR /tmp/

RUN mvn package
FROM jboss/wildfly
COPY --from=MAVEN_TOOL_CHAIN ./tmp/target/currency.war /opt/jboss/wildfly/standalone/deployments/currency.war