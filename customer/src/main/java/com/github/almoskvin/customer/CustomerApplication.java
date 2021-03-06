package com.github.almoskvin.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.github.almoskvin.customer",
                "com.github.almoskvin.amqp"
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.github.almoskvin.clients"
)
public class CustomerApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
}
