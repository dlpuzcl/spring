package edu.dlpu.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
    @Test
    public void testService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        OrderService orderService = (OrderService) applicationContext.getBean("orderService");
        orderService.account();
    }
}
