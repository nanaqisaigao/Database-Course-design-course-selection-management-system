package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.TeacherInfoDao;
import com.example.entity.Account;
import com.example.entity.TeacherInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherInfoService {
    @Resource
    private TeacherInfoDao teacherInfoDao;


    public void resigter(TeacherInfo teacherInfo) {
        //1.检查数据库中有没有同名的教师，如果有需要提示前台用户重新输入
        TeacherInfo Info = teacherInfoDao.findByName(teacherInfo.getName());
        if(ObjectUtil.isNotEmpty(Info)){
            //已经有教师用户了
            throw new CustomException(ResultCode.USER_EXIST_ERROR);//如果用户名一样，抛出异常，阻断登录，阻止数据库新增，提示用户名存在
        }
        //2.如果没有，说明可以注册，向数据库里新增一条数据

        teacherInfoDao.insertSelective(teacherInfo);
    }

    public Account login(String name, String password) {
        //通过用户名和密码去数据库里查一条记录出来
        TeacherInfo teacherInfo = teacherInfoDao.findByNameAndPass(name, password);

        if (ObjectUtil.isEmpty(teacherInfo)) {
            throw new CustomException("-1", "用户名，密码或角色错误");
        }
        return teacherInfo;
    }

    public TeacherInfo findById(Long id) {
        return teacherInfoDao.selectByPrimaryKey(id);
    }

    public void update(TeacherInfo teacherInfo) {
        teacherInfoDao.updateByPrimaryKeySelective(teacherInfo);
    }

}
