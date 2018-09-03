package edu.dlpu.anno;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService")
public class UserService {
    //得到dao对象
    //1。定义dao类型的属性
    //2。在dao的属性上面使用注解 完成对象注入


    //@Autowired
    //@Autowired自动装配，根据类名自动找
    //private UserDao userDao;

    @Resource(name = "userDao")
    //nmae属性值写注解创建dao对象的value的值
    private UserDao userDao;
    //使用注解的方式时不需要set方法
   public void add(){
       System.out.println("service.....");
       userDao.add();
   }


}
