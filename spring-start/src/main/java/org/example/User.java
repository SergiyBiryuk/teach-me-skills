package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    String uname;

    @Override
    public String toString() {
        return "User{" +
                "name='" + uname + '\'' +
                '}';
    }
}
