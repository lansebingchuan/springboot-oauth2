package com.zht.jwt.business.service.impl;

import com.zht.jwt.business.dao.UserDao;
import com.zht.jwt.business.entity.User;
import com.zht.jwt.business.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(String userName) {
        return userDao.findOneByUsername(userName);
    }

}
