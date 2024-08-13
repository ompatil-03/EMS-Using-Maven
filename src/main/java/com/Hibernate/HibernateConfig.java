package com.Hibernate;

import com.bean.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private  static SessionFactory sessionFactory;

    public static SessionFactory getSession(){
        Configuration cnf=new Configuration();
        Properties prop=new Properties();

        prop.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
        prop.put(Environment.URL,"jdbc:mysql://localhost:3306/hibernate");
        prop.put(Environment.USER,"root");
        prop.put(Environment.PASS,"Pass@1234");
        prop.put(Environment.HBM2DDL_AUTO,"create");
        prop.put(Environment.SHOW_SQL,"true");

        cnf.setProperties(prop);
        cnf.addAnnotatedClass(Employee.class);

        ServiceRegistry ssr=new StandardServiceRegistryBuilder().applySettings(cnf.getProperties()).build();

        sessionFactory=cnf.buildSessionFactory(ssr);
        return sessionFactory;

    }
}
