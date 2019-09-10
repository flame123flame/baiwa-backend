package baiwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"baiwa","egat","tpcc"})
@EnableJpaRepositories({"baiwa","egat","tpcc"})
@EntityScan({"baiwa","egat","tpcc"}) 
@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
public class BaiwaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaiwaApplication.class, args);
    }
}