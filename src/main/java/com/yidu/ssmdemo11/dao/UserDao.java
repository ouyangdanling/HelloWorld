package com.yidu.ssmdemo11.dao;

import com.yidu.ssmdemo11.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @描述:
 * @创建人 小欧
 * @时间 2021/4/16 11:01
 * @版本 1.0
 */
@Mapper
@Repository
public interface UserDao {
    /**
     * 登录
     * @param userName
     * @param userPass
     * @return 用户对
     */
    public UserInfo login(String userName, String userPass);

    public int add(UserInfo userInfo);
    /**
     * 查询所有
     */
    public List<UserInfo> selectAll();
}
