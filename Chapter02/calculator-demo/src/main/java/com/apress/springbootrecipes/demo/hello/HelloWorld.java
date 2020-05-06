package com.apress.springbootrecipes.demo.hello;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorld {
    @PostConstruct
    public void sayHello(){
        System.out.println("Hello World, from Spring Boot 2!");
    }
}
