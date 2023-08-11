package com.example.controller;

import com.example.common.Result;
import com.example.entity.XuankeInfo;
import com.example.service.XuankeInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

@RestController
@RequestMapping("xuankeInfo")
public class XuankeInfoController {
    @Resource
    XuankeInfoService xuankeInfoService;

    @GetMapping
    public Result findAll(){
        List<XuankeInfo> list = xuankeInfoService.findAllJoinTeacherAndZhuanye();
        return Result.success(list);
    };


}
