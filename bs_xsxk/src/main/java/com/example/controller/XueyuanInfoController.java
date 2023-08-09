package com.example.controller;

import com.example.common.Result;
import com.example.entity.XueyuanInfo;
import com.example.service.XueyuanInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("xueyuanInfo")
public class XueyuanInfoController {
    @Resource
    private XueyuanInfoService xueyuanInfoService;
    @GetMapping
    public Result findAll() {
        List<XueyuanInfo> list = xueyuanInfoService.findAll();
        return Result.success(list);
    }

    @PostMapping
    public Result add(@RequestBody XueyuanInfo xueyuanInfo) {
        xueyuanInfoService.add(xueyuanInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        xueyuanInfoService.deleteById(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody XueyuanInfo xueyuanInfo) {
        xueyuanInfoService.update(xueyuanInfo);
        return Result.success();
    }

    @GetMapping("/{search}")
    public Result find(@PathVariable String search) {
        List<XueyuanInfo> list = xueyuanInfoService.find(search);
        return Result.success(list);
    }


}
