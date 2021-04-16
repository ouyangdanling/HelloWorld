package com.yidu.ssmdemo11.controller;

import com.yidu.ssmdemo11.entity.UserInfo;
import com.yidu.ssmdemo11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @描述:
 * @创建人 小欧
 * @时间 2021/4/16 11:29
 * @版本 1.0
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 登录
     * @param userName 表单中传过来的用户名
     * @param userPass 表单中传过来的密 码
     * @return 响应页面
     */
    @RequestMapping("login") //设置请求地址
    //设置响应体
    public  @ResponseBody
    UserInfo login(String userName, String userPass){

        System.out.println("userName = " + userName + ", userPass = " + userPass);
        //调用数据库登录查询方法?明天做
        return userService.login(userName, userPass);
        //返回结果
        //return "登录成功！userName = " + userName + ", userPass = " + userPass;
    }

    @RequestMapping("register")
    @ResponseBody
    public String register(UserInfo userInfo){
        System.out.println("userInfo=="+userInfo.toString());
        //调用添加到数据库的方法
        String add = userService.add(userInfo);
        return add;
    }
    //ModelAndView /String
    @RequestMapping("selectAll")
    public String  selectAll(HttpServletRequest request){
        //调用数据库方法得到用户数据
        List<UserInfo> userInfos = userService.selectAll();
        //将数据存入作用域
        request.setAttribute("userList",userInfos);
        //跳转到指定页面，显示数据
        return  "userinfo";
    }
}
