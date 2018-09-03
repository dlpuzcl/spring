package edu.dlpu.service;

import edu.dlpu.dao.OrderDao;

public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    //调dao的方法
    //写业务逻辑，写转账业务
    public void account(){
        //小王少1000
        orderDao.lessMoney();

        //出现异常
        int i = 1/0;

        //小马多1000
        orderDao.moreMoney();
    }
}
