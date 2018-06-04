package com.jeffrey;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author Jeffrey.Liu
 * @version V1.0
 * @Description
 * @date 2018-6-3 22:39
 */
public class SpringDataTest {
    private ApplicationContext context = null;
    @Before
    public void setup(){
        context = new ClassPathXmlApplicationContext("beans-new.xml");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        context = null;
        System.out.println("tearDown");
    }

    @Test
    public void testEntityManagerFactory(){

    }
}
