package com.wen.service;

import com.wen.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author ：wenbo
 * @date ：Created in 2021/7/22 9:36 上午
 * @description：
 * @modified By：
 * @version: $
 */
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    public void find() {
        System.out.println("service find");
        userDao.query();
    }
}
