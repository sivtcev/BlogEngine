package com.sivtcev.blogEngine;

import com.sivtcev.blogEngine.configs.YamlProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
