package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.service.AdmininfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//共用用的功能
@RestController
@RequestMapping
public class AccountController {
    @Resource
    private AdmininfoService admininfoService;
    @PostMapping("/login")
    public  Result login(@RequestBody Account user,HttpServletRequest request){
        //校验数据是否填
        if(ObjectUtil.isEmpty(user.getName())||ObjectUtil.isEmpty(user.getPassword())||
                ObjectUtil.isEmpty(user.getLevel())){
                return Result.error("-1","输入的信息不完善");
        }
        //都有值
        Integer level = user.getLevel();
        Account loginUser = new Account();//用来统一接收登录信息
        if(1 == level){//管理员登陆,去管理员信息表查询，调用管理员Service的业务代码
            loginUser=admininfoService.login(user.getName(),user.getPassword());
        }
        if(2 == level){//教师登陆,去教师信息表查询

        }
        if(3 == level){//学生登陆,去学生信息表查询

        }
        //在session里面把用户信息存一份
        request.getSession().setAttribute("user",loginUser);

        return Result.success(loginUser);
        //这里把登陆的用户信息返回到前端
    }
}
