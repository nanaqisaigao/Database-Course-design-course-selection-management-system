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
    public Result update(@RequestBody TeacherInfo teacherInfo) {
        teacherInfoService.update(teacherInfo);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody TeacherInfo teacherInfo) {
        teacherInfoService.add(teacherInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<TeacherInfo> list = teacherInfoService.findAll();
        return Result.success(list);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") Long id){
        teacherInfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<TeacherInfo> info = teacherInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }

    @GetMapping("/{search}")//@RequestParam获取传进来的值
    public Result findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@PathVariable String search){
        //PageInfo里面包含list和很多页面信息
        PageInfo<TeacherInfo> info = teacherInfoService.findPageSearch(pageNum, pageSize,search);//返回的是PageInfo.of(列表);
        //MyBatis分页插件
        return Result.success(info);
    }

}
