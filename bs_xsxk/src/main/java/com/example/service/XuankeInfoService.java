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

    public List<XuankeInfo> findAll() {
        return xuankeInfoDao.selectAll();
    }

    public void add(XuankeInfo xuankeInfo) {
        xuankeInfoDao.insertSelective(xuankeInfo);
    }
}
