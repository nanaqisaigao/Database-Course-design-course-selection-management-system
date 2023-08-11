package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.Result;
import com.example.entity.Account;
import com.example.entity.ClassInfo;
import com.example.entity.XuankeInfo;
import com.example.exception.CustomException;
import com.example.service.ClassInfoService;
import com.example.service.XuankeInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/classInfo")
public class ClassInfoController {

    @Resource
    private ClassInfoService classInfoService;
    @Resource
    private XuankeInfoService xuankeInfoService;

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
    @PostMapping("/xuanke")
    public Result xuanke(@RequestBody ClassInfo classInfo, HttpServletRequest request){
        //如果课程已选人数是否达到开班人数（前端实现）
//      后端实现方法：  if (classInfo.getKaiban().equals(classInfo.getYixuan())) {
//            throw new CustomException("-1", "选课人数已满");
//        }
        Account user = (Account) request.getSession().getAttribute("user");//拿到当前登录用户

        //防止登录失效
        if(ObjectUtil.isEmpty(user)){
            throw new CustomException("-1","登陆已失效，请重新登录");
        }
        //防止重复选一门课
        Long id = user.getId();
        if(ObjectUtil.isNotEmpty(xuankeInfoService.selectByStudentId(id))){
            throw new CustomException("-1","你已经选过了");
        }
        //1,把课程信息塞进选课信息表里
        XuankeInfo xuankeInfo=new XuankeInfo();
        BeanUtils.copyProperties(classInfo,xuankeInfo);
//        BeanUtils.copyProperties，BeanUtils它提供了对java反射和自省API的包装如果有两个具有很多相同属性的JavaBean，用copyProperties
        xuankeInfo.setId(null);//清空classInfo传来的Id

        //2,把其他信息塞进选课信息表里
        xuankeInfo.setStudentId(user.getId());
        xuankeInfo.setStatus("待开课");
        xuankeInfoService.add(xuankeInfo);//调用选课信息服务的增加，存入选课的数据库中

        //3，课程信息表里已选人数加一
        classInfo.setYixuan(classInfo.getYixuan()+1);
        classInfoService.update(classInfo);

        return Result.success();
    }
}
