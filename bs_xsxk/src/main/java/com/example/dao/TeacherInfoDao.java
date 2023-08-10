package com.example.dao;

import com.example.entity.AdminInfo;
import com.example.entity.TeacherInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface TeacherInfoDao extends Mapper<TeacherInfo> {


    @Select("select * from teacher_info where name=#{name}")
    TeacherInfo findByName(@Param("name") String name);

    @Select("select * from teacher_info where name = #{name} and password = #{password}")
    TeacherInfo findByNameAndPass(@Param("name") String name, @Param("password") String password);

//    @Select("select * from teacher_info where name like concat('%', #{search}, '%')")
    @Select("SELECT a.*,b.name AS zhuanyeName\n" +//增加一个新表外元素后的查询
            "FROM teacher_info AS a\n" +
            "LEFT JOIN zhuanye_info AS b\n" +
            "ON a.zhuanyeId = b.id\n" +
            "WHERE a.name LIKE CONCAT('%',#{search},'%')")
    List<TeacherInfo> findByLikeName(@Param("search") String search);//模糊查询

    @Select("SELECT a.*,b.name AS zhuanyeName\n" +
            "FROM teacher_info AS a\n" +
            "LEFT JOIN zhuanye_info AS b\n" +
            "ON a.zhuanyeId = b.id")
    List<TeacherInfo> findAllJoinXueyuan();
}



