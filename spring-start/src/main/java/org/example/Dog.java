package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {
    @Autowired
    String dogName;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + dogName + '\'' +
                '}';
    }
}
