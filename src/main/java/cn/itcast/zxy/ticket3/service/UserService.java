package cn.itcast.zxy.ticket3.service;


import cn.itcast.zxy.ticket3.domain.User;

public interface UserService {
    public User login(User user);
    public void register(User user);
}
