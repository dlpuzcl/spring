package edu.dlpu.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Jdbc_template {



    //1.添加操作
    @Test
    public void add() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_03");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql = "insert into user values(?,?)";

        int row = jdbcTemplate.update(sql,"tom","3");

        System.out.println(row);

    }
    //2.修改操作
    @Test
    public void update() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_03");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql = "update user set username=? where password=? ";

        int row = jdbcTemplate.update(sql, "dfdf", "250");

        System.out.println(row);
    }
    //2.删除操作
    @Test
    public void delete() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_03");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);


        //调用jdbcTemplate对象里面的方法实现操作
        //创建sql语句
        String sql = "delete from user where username=? ";

        int row = jdbcTemplate.update(sql,"dfdf");

        System.out.println(row);

    }




}
