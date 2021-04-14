package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public String dogName() {
        return "DogName";
    }

    @Bean
    public String uname() {
        return "Holop";
    }

    @Bean
    public String catName() {
        return "CatName";
    }

    @Bean
    public Cat getCat(String catName) {
        return new Cat(catName);
    }

}
