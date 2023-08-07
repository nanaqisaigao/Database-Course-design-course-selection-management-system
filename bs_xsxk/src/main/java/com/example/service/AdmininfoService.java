package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.AdminInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdmininfoService {
    @Resource
    private AdminInfoDao adminInfoDao;

    public Account login(String name, String password) {
        //通过用户名和密码去数据库里查一条记录出来
        AdminInfo adminInfo = adminInfoDao.findByNameAndPass(name, password);

        if (ObjectUtil.isEmpty(adminInfo)) {
            throw new CustomException("-1", "用户名，密码或角色错误");
        }
        return adminInfo;
    }

    public AdminInfo findById(Long id) {

        return adminInfoDao.selectByPrimaryKey(id);
    }

    public void update(AdminInfo adminInfo) {

        adminInfoDao.updateByPrimaryKeySelective(adminInfo);
    }

    public void add(AdminInfo adminInfo) {
        //判断是否重名
        AdminInfo info =adminInfoDao.findByName(adminInfo.getName());
        if(ObjectUtil.isNotEmpty(info)){//不空就是有重名
            throw new CustomException(ResultCode.USER_EXIST_ERROR);//如果用户名一样，抛出异常，阻断登录，阻止数据库新增，提示用户名存在
        }
        //由于新增管理员没有密码字段，需要初始化一个密码
        if(ObjectUtil.isEmpty(adminInfo.getPassword())){
            adminInfo.setPassword("123456");
        }
        adminInfoDao.insertSelective(adminInfo);
    }

}
