package com.example.controller;

import com.example.common.Result;
import com.example.entity.ZhuanyeInfo;
import com.example.service.ZhuanyeInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/zhuanyeInfo")
public class ZhuanyeInfoController {

    @Resource
    private ZhuanyeInfoService zhuanyeInfoService;

    @PostMapping
    public Result add(@RequestBody ZhuanyeInfo zhuanyeInfo) {
        zhuanyeInfoService.add(zhuanyeInfo);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        zhuanyeInfoService.deleteById(id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody ZhuanyeInfo zhuanyeInfo) {
        zhuanyeInfoService.update(zhuanyeInfo);
        return Result.success();
    }

    @GetMapping
    public Result findAll() {
        List<ZhuanyeInfo> list = zhuanyeInfoService.findAll();
        return Result.success(list);
    }

    @GetMapping("/{search}")
    public Result findSearch(@PathVariable String search) {
        List<ZhuanyeInfo> list = zhuanyeInfoService.findSearch(search);
        return Result.success(list);
    }

}
