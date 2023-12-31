package com.example.dao;

import com.example.entity.XuankeInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface XuankeInfoDao extends Mapper<XuankeInfo> {
    @Select("SELECT a.*,b.name AS teacherName,c.name AS studentName,d.name AS zhuanyeName\n" +
            "FROM xuanke_info AS a\n" +
            "INNER JOIN teacher_info AS b\n" +
            "INNER JOIN student_info AS c\n" +
            "INNER JOIN zhuanye_info AS d\n" +
            "ON a.teacherId=b.id AND a.studentId=c.id AND a.zhuanyeId = d.id")
    List<XuankeInfo> findAllJoinTeacherAndZhuanye();

//    @Select("SELECT * FROM xuanke_info WHERE studentId = #{ID}")
//    XuankeInfo SelectByStudentId(@Param("ID") Long ID); 这个会导致一个人只能选一门课

    @Select("SELECT * FROM xuanke_info WHERE studentId=#{studentId} AND name=#{name}")
    XuankeInfo selectByThreeInfo(@Param("name") String name, @Param("studentId") Long studentId);

    @Delete("DELETE FROM xuanke_info WHERE name = #{classname} AND studentId = #{studentId}")
    void tuike(@Param("classname") String classname, @Param("studentId") Long studentId);

    @Select("SELECT a.*,b.name AS teacherName,c.name AS studentName,d.name AS zhuanyeName\n" +
            "FROM xuanke_info AS a\n" +
            "INNER JOIN teacher_info AS b\n" +
            "INNER JOIN student_info AS c\n" +
            "INNER JOIN zhuanye_info AS d\n" +
            "ON a.teacherId=b.id AND a.studentId=c.id AND a.zhuanyeId = d.id\n" +
            "WHERE  a.teacherId=#{teacherId}"    )
    List<XuankeInfo> findAllJoinTeacherAndZhuanyeThroughTeacherId(@Param("teacherId") Long teacherId);

    @Select("SELECT a.*,b.name AS teacherName,c.name AS studentName,d.name AS zhuanyeName\n" +
            "FROM xuanke_info AS a\n" +
            "INNER JOIN teacher_info AS b\n" +
            "INNER JOIN student_info AS c\n" +
            "INNER JOIN zhuanye_info AS d\n" +
            "ON a.teacherId=b.id AND a.studentId=c.id AND a.zhuanyeId = d.id\n" +
            "WHERE  a.studentId=#{studentId}")
    List<XuankeInfo> findAllJoinTeacherAndZhuanyeThroughStudentId(@Param("studentId") Long studentId);

}
