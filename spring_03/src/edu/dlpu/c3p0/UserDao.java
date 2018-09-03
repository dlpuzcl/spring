package edu.dlpu.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //添加操做
    public void add() {
        //创建jdbcTemplate对象
//       JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSource)
        String sql = "insert into user values(?,?)";
        jdbcTemplate.update(sql,"集积极","520");

    }

}
