package com.projects.hruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = {"com.projects"})
@SpringBootApplication
public class HrUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrUserApplication.class, args);
    }

}
