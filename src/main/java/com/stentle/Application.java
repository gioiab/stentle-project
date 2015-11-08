package com.stentle;

/**
 * Created by gioiaballin on 05/11/15.
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import com.mongodb.MongoClient;

/**
 * Test configuration to connect to a MongoDB named "test" and using a {@link MongoClient}.
 *
 * @author Gioia Ballin
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Create a new {@link LocalValidatorFactoryBean} to get the validation on nested objects.
     *
     */
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }

}