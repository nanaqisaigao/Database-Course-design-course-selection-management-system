package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.print.attribute.standard.PageRanges;
import java.util.List;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    @Resource
    private AdminInfoService admininfoService;

    @PutMapping
    public Result update(@RequestBody AdminInfo adminInfo){
        admininfoService.update(adminInfo);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody AdminInfo adminInfo){
        admininfoService.add(adminInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll(){
        List<AdminInfo> list = admininfoService.findAll();
        return Result.success(list);
    }

    @DeleteMapping("/{id}")
    public  Result deleteById(@PathVariable(value = "id") Long id){
        admininfoService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo<AdminInfo> info = admininfoService.findPage(pageNum, pageSize);
        return Result.success(info);
    }

    @GetMapping("/page/{name}")//@RequestParam获取传进来的值
    public Result findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize,@PathVariable String name){
        //PageInfo里面包含list和很多页面信息
        PageInfo<AdminInfo> info = admininfoService.findPageName(pageNum, pageSize,name);//返回的是PageInfo.of(列表);
        //MyBatis分页插件
        return Result.success(info);
    }
}
