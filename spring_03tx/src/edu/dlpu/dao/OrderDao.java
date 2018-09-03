package edu.dlpu.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
    //注入jdbcTemplate模版
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 做对数据库操作的方法，不写业务的操作
     */

    //少钱的方法
    public void lessMoney(){
        String sql = "update account set salary = salary - ? where username = ?";
        jdbcTemplate.update(sql,1000,"xiaowang");
    }

    //多钱的方法
    public void moreMoney(){
        String sql = "update account set salary = salary + ? where username = ?";
        jdbcTemplate.update(sql,1000,"xiaoma");
    }
}
