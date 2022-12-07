package cn.itcast.zxy.ticket3.service.impl;


import cn.itcast.zxy.ticket3.dao.UserDao;
import cn.itcast.zxy.ticket3.dao.impl.UserDaoImpl;
import cn.itcast.zxy.ticket3.domain.User;
import cn.itcast.zxy.ticket3.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.findUserByNameAndPassword(user.getName(),user.getPassword());
    }

    @Override
    public void register(User user) {
        userDao.register(user);
    }

}
