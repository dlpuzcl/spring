package edu.dlpu.zcl;

import edu.dlpu.property.Book;
import edu.dlpu.property.Persion;
import edu.dlpu.property.PropertyDemo1;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void testUser(){
        //1.加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.得倒创建配置的对象

       User user = (User) context.getBean("user");
       User user2 = (User) context.getBean("user");
       System.out.println(user);
       System.out.println(user2);
       user.add();
    }

    @Test
    public void testProperty(){
        //1.加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.得到创建配置的对象

       PropertyDemo1 demo1 = (PropertyDemo1) context.getBean("demo");

       demo1.test1();
    }
    @Test
    public void testBookProperty() {
        //1.加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.得到创建配置的对象

        Book book = (Book) context.getBean("book");

        book.demobook();
    }
    @Test
    public void test1Class(){
        //1.加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.得到创建配置的对象

       UserService userService = (UserService) context.getBean("userservice");

       userService.add();
    }
    @Test
    public void test2Class(){
        //1.加载spring配置文件，根据创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");

        //2.得到创建配置的对象

       Persion persion = (Persion) context.getBean("persion");

       persion.test1();
    }
}
