package com.example.dao;

import com.example.entity.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface ClassInfoDao extends Mapper<ClassInfo> {

    @Select("select a.*, b.name AS teacherName , c.name AS zhuanyeName\n" +
            "from class_info AS a \n" +
            "INNER JOIN teacher_info AS b \n" +
            "RIGHT JOIN zhuanye_info AS c\n" +
            "ON a.teacherId = b.id AND a.zhuanyeId = c.id\n" +
            "where a.name like concat('%',#{search},'%')")
    List<ClassInfo> findSearch(@Param("search") String search);

    @Select("select a.*, b.name AS teacherName , c.name AS zhuanyeName\n" +
            "from class_info AS a \n" +
            "INNER JOIN teacher_info AS b \n" +
            "INNER JOIN zhuanye_info AS c\n" +
            "ON a.teacherId = b.id AND a.zhuanyeId = c.id")
    List<ClassInfo> findAll();

    @Select("select * from class_info where name = #{name}")
    ClassInfo selectByName(@Param("name") String name);
}