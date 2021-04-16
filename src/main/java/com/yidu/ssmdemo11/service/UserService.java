package com.yidu.ssmdemo11.service;

import com.yidu.ssmdemo11.dao.UserDao;
import com.yidu.ssmdemo11.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述:
 * @创建人 小欧
 * @时间 2021/4/16 11:22
 * @版本 1.0
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public UserInfo login(String userName, String userPass){
        return userDao.login(userName, userPass);
    }

    public String add(UserInfo userInfo){
        int add = userDao.add(userInfo);
        return  add>0?"新增成功！":"新增失败";
    }

    public List<UserInfo> selectAll(){
        return   userDao.selectAll();
    }
}
