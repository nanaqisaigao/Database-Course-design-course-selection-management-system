package com.example.controller;

import com.example.common.Result;
import com.example.entity.AdminInfo;
import com.example.service.AdmininfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/adminInfo")
public class AdminInfoController {
    @Resource
    private AdmininfoService admininfoService;

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

}
