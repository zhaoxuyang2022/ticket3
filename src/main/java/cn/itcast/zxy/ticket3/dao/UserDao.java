package cn.itcast.zxy.ticket3.dao;


import cn.itcast.zxy.ticket3.domain.User;

public interface UserDao {
    public User findUserByNameAndPassword(String name, String password);

    public void register(User user);
}


