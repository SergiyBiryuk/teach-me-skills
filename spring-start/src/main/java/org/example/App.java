package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext app = new AnnotationConfigApplicationContext("org.example");
        Dog dog = app.getBean("dog", Dog.class);
        Cat cat = app.getBean("getCat", Cat.class);
        User user = (User) app.getBean("user");
        System.out.println(dog);
        System.out.println(cat);
        System.out.println(user);


    }
}
