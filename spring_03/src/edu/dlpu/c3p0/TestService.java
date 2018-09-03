package edu.dlpu.c3p0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestService {
    @Test
    public void testService(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.add();
    }
}
