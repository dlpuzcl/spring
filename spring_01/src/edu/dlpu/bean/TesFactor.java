package edu.dlpu.bean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TesFactor {
    @Test
    public void testUser(){
        //1.加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.得倒创建配置的对象

       Bean3 bean3 = (Bean3) context.getBean("bean3");
        System.out.println(bean3);
    }
}
