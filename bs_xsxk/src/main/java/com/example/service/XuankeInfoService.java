package com.example.service;

import com.example.dao.XuankeInfoDao;
import com.example.entity.XuankeInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XuankeInfoService {
    @Resource
    private XuankeInfoDao xuankeInfoDao;



    public void add(XuankeInfo xuankeInfo) {
        xuankeInfoDao.insertSelective(xuankeInfo);
    }



    public List<XuankeInfo> findAll() {
        return xuankeInfoDao.selectAll();
    }
    public List<XuankeInfo> findAllJoinTeacherAndZhuanye() {
        return xuankeInfoDao.findAllJoinTeacherAndZhuanye();
    }
//    public XuankeInfo selectByStudentId(Long id) {
//        return xuankeInfoDao.SelectByStudentId(id);
//    }这会导致一个人只能选一门课
    public XuankeInfo selectByThreeInfo(String name, Long studentId) {
        return xuankeInfoDao.selectByThreeInfo(name, studentId);
    }

    public void tuike(String classname, Long studentId) {
        xuankeInfoDao.tuike(classname,studentId);
    }
}
