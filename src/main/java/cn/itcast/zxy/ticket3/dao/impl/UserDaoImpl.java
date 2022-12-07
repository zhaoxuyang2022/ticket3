package cn.itcast.zxy.ticket3.dao.impl;

import cn.itcast.zxy.ticket3.dao.UserDao;
import cn.itcast.zxy.ticket3.domain.User;
import cn.itcast.zxy.ticket3.util.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public User findUserByNameAndPassword(String name, String password) {
        try {
            String sql = "select * from user where name = ? and password = ?";
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void register(User user) {
        String sql = "insert into user values(null,?,?,?,null)";
        jdbcTemplate.update(sql,user.getName(),user.getTelephone(),user.getPassword());
    }
}
