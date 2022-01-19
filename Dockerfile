FROM momagano/dummy-spring-boot
# RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=/server/target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]