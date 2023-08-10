package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.ResultCode;
import com.example.dao.TeacherInfoDao;
import com.example.entity.Account;
import com.example.entity.AdminInfo;
import com.example.entity.TeacherInfo;
import com.example.exception.CustomException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public void add(TeacherInfo teacherInfo) {
        //判断是否重名
        TeacherInfo info =teacherInfoDao.findByName(teacherInfo.getName());
        if(ObjectUtil.isNotEmpty(info)){//不空就是有重名
            throw new CustomException(ResultCode.USER_EXIST_ERROR);//如果用户名一样，抛出异常，阻断登录，阻止数据库新增，提示用户名存在
        }
        //由于新增用户没有密码字段，需要初始化一个密码
        if(ObjectUtil.isEmpty(teacherInfo.getPassword())){
            teacherInfo.setPassword("123456");
        }
        teacherInfo.setLevel(2);
        teacherInfoDao.insertSelective(teacherInfo);
    }

    public List<TeacherInfo>findAll(){
        return teacherInfoDao.selectAll();

    }

    public void deleteById(Long id) {
        teacherInfoDao.deleteByPrimaryKey(id);
    }

    public PageInfo<TeacherInfo> findPage(Integer pageNum, Integer pageSize) {
        //1.开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2.之后的查询会自动根据pageNum和pageSize来查询对应的数据
//        List<TeacherInfo> infos = teacherInfoDao.selectAll();
        List<TeacherInfo> infos =teacherInfoDao.findAllJoinXueyuan();
        return PageInfo.of(infos);
    }

    public PageInfo<TeacherInfo> findPageSearch(Integer pageNum, Integer pageSize, String search) {
        //1.开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2.之后的查询会自动根据pageNum和pageSize来查询对应的数据
        List<TeacherInfo> infos = teacherInfoDao.findByLikeName(search);
        return PageInfo.of(infos);
    }
}
