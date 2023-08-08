package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.StudentInfoDao;
import com.example.entity.Account;
import com.example.entity.StudentInfo;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentInfoService {
    @Resource
    private StudentInfoDao studentInfoDao;


    public void resigter(StudentInfo studentInfo) {
        //1.检查数据库中有没有同名的学生，如果有需要提示前台用户重新输入
        StudentInfo Info = studentInfoDao.findByName(studentInfo.getName());
        if(ObjectUtil.isNotEmpty(Info)){
            //已经有学生用户了
            throw new CustomException(ResultCode.USER_EXIST_ERROR);//如果用户名一样，抛出异常，阻断登录，阻止数据库新增，提示用户名存在
        }
        //2.如果没有，说明可以注册，向数据库里新增一条数据
        studentInfoDao.insertSelective(studentInfo);
    }

    public Account login(String name, String password) {
        //通过用户名和密码去数据库里查一条记录出来
        StudentInfo studentInfo = studentInfoDao.findByNameAndPass(name, password);
        if (ObjectUtil.isEmpty(studentInfo)) {
            throw new CustomException("-1", "用户名，密码或角色错误");
        }
        return studentInfo;
    }

    public StudentInfo findById(Long id) {
        return studentInfoDao.selectByPrimaryKey(id);
    }

    public void update(StudentInfo studentInfo) {
        studentInfoDao.updateByPrimaryKeySelective(studentInfo);
    }

}
