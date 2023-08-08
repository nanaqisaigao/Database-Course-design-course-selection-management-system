package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.entity.TeacherInfo;
import com.example.service.AdminInfoService;
import com.example.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teacherInfo")
public class TeacherInfoController {
    @Resource
    private TeacherInfoService teacherInfoService;

    @PutMapping
    public Result update(@RequestBody TeacherInfo teacherInfo){
        teacherInfoService.update(teacherInfo);
        return Result.success();
    }


}
