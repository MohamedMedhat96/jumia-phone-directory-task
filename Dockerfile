FROM openjdk:8
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ADD src/main/resources/sample.db src/main/resources/sample.db
ADD src/main/resources/add_column.sql src/main/resources/add_column.sql
ADD src/main/resources/data.sql src/main/resources/data.sql
ENTRYPOINT ["java","-jar","/app.jar"]