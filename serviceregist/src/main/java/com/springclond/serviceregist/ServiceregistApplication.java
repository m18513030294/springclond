package com.springclond.serviceregist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceregistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceregistApplication.class, args);
    }
}
