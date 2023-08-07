package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.service.AdminInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
}
