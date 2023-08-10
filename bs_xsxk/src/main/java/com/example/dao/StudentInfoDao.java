package com.example.dao;

import com.example.entity.StudentInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface StudentInfoDao extends Mapper<StudentInfo> {


    @Select("select * from student_info where name=#{name}")
    StudentInfo findByName(@Param("name") String name);

    @Select("select * from student_info where name = #{name} and password = #{password}")
    StudentInfo findByNameAndPass(@Param("name") String name, @Param("password") String password);

  /*  @Select("select * from student_info where name like concat('%',#{search},'%')")
    List<StudentInfo> findByLikeName(@Param("name")String search);*/
    //增加了信息后的模糊查询
    @Select("select a.*,b.name AS xueyuanName \n" +
            "FROM student_info AS a \n" +
            "LEFT JOIN xueyuan_info AS b \n" +
            "ON a.xueyuanId = b.id \n" +
            "where a.name like concat('%',#{search},'%')")
    List<StudentInfo> findByLikeName(@Param("search") String search);

    @Select("SELECT a.*,b.name AS xueyuanName " +
            "FROM student_info AS a " +
            "LEFT JOIN xueyuan_info AS b " +
            "ON a.xueyuanId = b.id")
    List<StudentInfo> findAllJoinXueyuan();

    @Select("SELECT a.*,b.name AS xueyuanName " +
            "FROM student_info AS a " +
            "LEFT JOIN xueyuan_info AS b " +
            "ON a.xueyuanId = b.id"+
            "WHERE a.id = #{ID}")
    StudentInfo SelectByIdJoinXueyuan(@Param("ID") Long ID);
}



