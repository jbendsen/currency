FROM maven:3.5.2-jdk-9 AS build  
COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM jboss/wildfly
COPY --from=build /usr/src/app/target/currency.war /opt/jboss/wildfly/standalone/deployments/
 


