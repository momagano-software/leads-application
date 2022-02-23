package za.co.momagano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"za.co.momagano"})
@EnableJpaRepositories(basePackages = {"za.co.momagano"})
public class DummyApplication {
    public static void main(String[] args) {
        SpringApplication.run(DummyApplication.class, args);
    }
}
