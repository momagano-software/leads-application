# FROM momagano/dummy-spring-boot
# # RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
# ARG JAR_FILE=/server/target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
FROM maven:3-jdk-8

WORKDIR /app

# COPY .mvn/ .mvn
COPY pom.xml ./
# COPY mvnw pom.xml ./
COPY server ./server
COPY web ./web
# RUN mvn dependency:go-offline

# run ./mvnw clean install
run mvn clean install
# CMD ["./mvnw", "clean install"]

# RUN cd server
# RUN ls -l server
# RUN echo 'HERERERERERERERERERERERERERERrrrrrrrrRRRRRRRRRRRRRRRRRRRRRRrrrrreeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer'
# RUN pwd

# run ./mvnw spring-boot:run
# run mvn spring-boot:run -f server/pom.xml
CMD ["mvn", "-fserver/pom.xml", "spring-boot:run"]