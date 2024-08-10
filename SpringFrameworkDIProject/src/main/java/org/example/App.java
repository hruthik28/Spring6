package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        ApplicationContext context = new  ClassPathXmlApplicationContext("spring.xml");

        //Dev obj = context.getBean(Dev.class);
        Dev obj = (Dev) context.getBean("dev"); // if using id for bean in configuration, id is optional for bean creation, but class is mandatory
        obj.build();
    }
}
