package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.StudentInfo;
import com.example.entity.XuankeInfo;
import com.example.exception.CustomException;
import com.example.service.StudentInfoService;
import com.example.service.XuankeInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.*;

@RestController
@RequestMapping("/xuankeInfo")
public class XuankeInfoController {
    @Resource
    XuankeInfoService xuankeInfoService;
    @Resource
    StudentInfoService studentInfoService;

    @GetMapping
    public Result findAll(HttpServletRequest request) {//根据登录的用户是谁，来显示只能和自己相关的选课内容，不能侵犯他人隐私
        Account user = (Account) request.getSession().getAttribute("user");
        if (ObjectUtil.isEmpty(user)) {
            throw new CustomException("-1", "登录失效，请重新登陆");
        }
        if (1 == user.getLevel()) {
            //管理员
            //管理员可以看到所有的算可信息
            List<XuankeInfo> list = xuankeInfoService.findAllJoinTeacherAndZhuanye();
            return Result.success(list);
        } else if (2 == user.getLevel()) {
            //教师
            //教师只能看到自己代课的的选课信息
            List<XuankeInfo> list = xuankeInfoService.findAllJoinTeacherAndZhuanyeThroughTeacherId(user.getId());
            return Result.success(list);
        } else if (3 == user.getLevel()) {
            //学生
            //学生只能看到自己的选课信息
            List<XuankeInfo> list = xuankeInfoService.findAllJoinTeacherAndZhuanyeThroughStudentId(user.getId());
            return Result.success(list);
        } else
            return Result.error();


    }

    ;

    @PutMapping("/kaike")
    public Result kaikeupdate(@RequestBody XuankeInfo xuankeInfo) {
        xuankeInfoService.update(xuankeInfo);
        return Result.success();
    }

    @PutMapping("/jieke")
    public Result jiekeupdate(@RequestBody XuankeInfo xuankeInfo) {
        //给选课学生增加学分
        Long studentId = xuankeInfo.getStudentId();
        StudentInfo student = studentInfoService.findById(studentId);
        student.setScore(student.getScore()+ xuankeInfo.getScore());
        studentInfoService.update(student);
        //更新课程状态
        xuankeInfoService.update(xuankeInfo);
        return Result.success();
    }


}
