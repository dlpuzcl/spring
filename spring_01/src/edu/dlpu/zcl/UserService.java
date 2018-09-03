package edu.dlpu.zcl;

public class UserService {
    //1。定义dao的类型属性
    private UserDao userDao;

    //2。生成set方法
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(){
        System.out.println("service......");

            //在service里得到dao对象，才能调用dao里面的方法
//        UserDao dao = new UserDao();
//        dao.add();
        userDao.add();

    }
}
