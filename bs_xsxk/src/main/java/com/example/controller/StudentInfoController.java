package com.example.controller;

import com.example.common.Result;
import com.example.entity.StudentInfo;
import com.example.entity.TeacherInfo;
import com.example.service.StudentInfoService;
import com.example.service.TeacherInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/studentInfo")
public class StudentInfoController {
    @Resource
    private StudentInfoService studentInfoService;

    @PutMapping
    public Result update(@RequestBody StudentInfo studentInfo){
        studentInfoService.update(studentInfo);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody StudentInfo studentInfo) {
        studentInfoService.add(studentInfo);
        return Result.success();
    }
    @GetMapping
    public Result findAll() {
        List<StudentInfo> list = studentInfoService.findAll();
        return Result.success(list);
    }
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(value = "id") Long id){
        studentInfoService.deleteById(id);
        return Result.success();
    }
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<StudentInfo> info = studentInfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }

    @GetMapping("/{search}")//@RequestParam获取传进来的值
    public Result findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@PathVariable String search){
        //PageInfo里面包含list和很多页面信息
        PageInfo<StudentInfo> info = studentInfoService.findPageSearch(pageNum, pageSize,search);//返回的是PageInfo.of(列表);
        //MyBatis分页插件
        return Result.success(info);
    }
}
