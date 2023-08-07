package com.example.dao;

import com.example.entity.AdminInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;//这个mybatis的mapper框架，包含基本的增删改查，根据主键查询啥的

@Repository
public interface AdminInfoDao extends Mapper<AdminInfo> {

    @Select("select * from admin_info where name = #{name} and password = #{password}")
    AdminInfo findByNameAndPass(@Param("name") String name,@Param("password") String password);
    @Select("select * from admin_info where name = #{name}")
    AdminInfo findByName(@Param("name") String name);

}



