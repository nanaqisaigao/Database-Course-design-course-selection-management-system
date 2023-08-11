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

    public XuankeInfo selectByStudentId(Long id) {
        return xuankeInfoDao.SelectByStudentId(id);
    }

    public List<XuankeInfo> findAll() {
        return xuankeInfoDao.selectAll();
    }
    public List<XuankeInfo> findAllJoinTeacherAndZhuanye() {
        return xuankeInfoDao.findAllJoinTeacherAndZhuanye();
    }
}
