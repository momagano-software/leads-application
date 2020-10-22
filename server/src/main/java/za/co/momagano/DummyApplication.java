package za.co.momagano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.momagano"})
public class DummyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DummyApplication.class, args);
    }
}
