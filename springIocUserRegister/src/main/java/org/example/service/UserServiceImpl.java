package org.example.service;

import org.example.dao.UserDao;
import org.example.domain.SysUser;

public class UserServiceImpl implements UserService {
    //引用类型
    private UserDao userDao =null;//赋值是在xml配置文件中实现的，解耦合

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(SysUser user) {
        userDao.insertUser(user);
    }
}
