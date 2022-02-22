docker build -t <image-name>

docker run -p 8080:8080 <image-name>

Uncomment  ```CMD ["mvn", "-fserver/pom.xml", "spring-boot:run"]```  on Dockerfile to run locally