package com.example.controller;

import com.example.common.Result;
import com.example.entity.ClassInfo;
import com.example.service.ClassInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/classInfo")
public class ClassInfoController {

    @Resource
    private ClassInfoService classInfoService;

    @PostMapping
    public Result add(@RequestBody ClassInfo classInfo) {
        classInfoService.add(classInfo);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody ClassInfo classInfo) {
        classInfoService.update(classInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        classInfoService.delete(id);
        return Result.success();
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search) {
        List<ClassInfo> list = classInfoService.findSearch(search);
        return Result.success(list);
    }

    @GetMapping
    public Result findAll() {
        List<ClassInfo> list = classInfoService.findAll();
        return Result.success(list);
    }

}
