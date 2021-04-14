package org.example;


import org.springframework.stereotype.Component;

@Component
public class Cat {

    String catName;

    public Cat(String catName) {
        this.catName = catName;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + catName + '\'' +
                '}';
    }
}
