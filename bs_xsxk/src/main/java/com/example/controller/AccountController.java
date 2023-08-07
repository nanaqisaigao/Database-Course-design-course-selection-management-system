package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//共用用的功能
@RestController
@RequestMapping
public class AccountController {
    @Resource
    private AdminInfoService admininfoService;
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

    @GetMapping("/getUser")
    public Result getUser(HttpServletRequest request){
        //先从session里面获取当前存的用户登录的信息
        Account user = (Account) request.getSession().getAttribute("user");
        //判断当前登录的用户是什么角色
        Integer level = user.getLevel();
        if(1 == level){//管理员登陆,去管理员信息表查询，调用管理员Service的业务代码
            //获取管理员信息
           AdminInfo adminInfo = admininfoService.findById(user.getId());//通过登录模块保存的主键，在AdminInfo服务和Dao获取表中SQL管理员信息
            return Result.success(adminInfo);
        }
        if(2 == level){//教师登陆,去教师信息表查询
            //从教师表里面获取教师信息
        }
        if(3 == level){//学生登陆,去学生信息表查询
            //从学生表里获取学生信息
        }

            return Result.success(new Account());
    }
}
