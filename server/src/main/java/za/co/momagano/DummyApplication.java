package za.co.momagano;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableSwagger2
@SpringBootApplication
@EnableAspectJAutoProxy
public class DummyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DummyApplication.class, args);
    }
}
