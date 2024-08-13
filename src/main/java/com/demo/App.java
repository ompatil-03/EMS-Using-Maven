package com.demo;

import com.Hibernate.HibernateConfig;
import org.hibernate.SessionFactory;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello world");
        SessionFactory sf= HibernateConfig.getSession();
        System.out.println(sf);
    }
}
