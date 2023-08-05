package com.example.controller;

import com.example.service.AdmininfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admininfo")
public class AdminInfoController {
    @Resource
    private AdmininfoService admininfoService;
}
