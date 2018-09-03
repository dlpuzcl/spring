package edu.dlpu.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Controller
//@Service
//@Repository
@Component(value = "user")
@Scope(value = "prototype")
public class User {

    public  void add(){
        System.out.println("add.......");
    }
}
