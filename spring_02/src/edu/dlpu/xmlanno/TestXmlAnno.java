package edu.dlpu.xmlanno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXmlAnno {
    @Test
    public void testXmlAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        BookService bookService = (BookService) context.getBean("bookService");
        bookService.add();
    }
}
