package com.shop.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {
    public static void main(String[] args) {

        Hello hello = new Hello();
        hello.setData("Hello");
        String data = hello.getData();
        System.out.println("data123="+data);

        SpringApplication.run(ShoppingApplication.class, args);
    }
}
