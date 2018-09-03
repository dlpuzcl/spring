package edu.dlpu.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.*;
import java.util.List;

public class Jdbc_template_query {
    /**
     * 1.dbutils时候，有接口ResultSetHandler
     * dbutils提供了针对不同的结果实现类
     *
     *
     * 2.jdbcTemplate实现查询，有接口RowMapper,
     * jdbcTemplatel针对这个接口没有提供实现类，得到不同的类型数据需要自己进行数据封装
     */




    //1.查询返回某一个值
    @Test
    public void testCount() {
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
        String sql = "select count(*) from user";

        int count = jdbcTemplate.queryForObject(sql,Integer.class);

        System.out.println(count);

    }

    //2 jdbc实现代码
    @Test
    public void testJdbc(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql:///spring_03","root","123456");
            //编写sql语句
            String sql = "select * from user where username=?";
            //预编译sql
            preparedStatement = connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setString(1,"lucy");
            //执行sql
            resultSet = preparedStatement.executeQuery();
            //遍历结果集
            while (resultSet.next()){
                //得到结果值
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                //放到user对象里面
                User user = new User();
                user.setPassword(password);
                user.setUsername(username);

                System.out.println(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }


    //3.查询返回某个对象
    @Test
    public void testObject() {
        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_03");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);



        //创建sql语句
        String sql = "select * from user where username = ?";

        ////调用jdbcTemplate对象里面的方法实现操作

        //第二个参数是接口RowMapper，需要自己写实现 类接口自己做数据的封装
        User user = jdbcTemplate.queryForObject(sql,new MyRowMapper(),"tom");

        System.out.println(user);

    }
    //3.查询返回list
    @Test
    public void testList() {

        //c3p0连接池
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("com.mysql.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql:///spring_03");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");



        //设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_03");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        //创建jdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);



        //创建sql语句
        String sql = "select * from user";

        ////调用jdbcTemplate对象里面的方法实现操作

        //第二个参数是接口RowMapper，需要自己写实现 类接口自己做数据的封装
        List<User> list = jdbcTemplate.query(sql,new MyRowMapper());

        System.out.println(list);

    }
}

class MyRowMapper implements RowMapper<User>{

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        //1.从结果集里面把数据得到
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");

        //2.把得到数据封装到对象里

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
