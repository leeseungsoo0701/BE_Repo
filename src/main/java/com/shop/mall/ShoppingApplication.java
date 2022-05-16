package com.shop.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingApplication {
    public static void main(String[] args) {

        Hello1 hello1 = new Hello1();
        hello1.setData("Hello");
        String data = hello1.getData();
        System.out.println("data123="+data);

        SpringApplication.run(ShoppingApplication.class, args);
    }
}
