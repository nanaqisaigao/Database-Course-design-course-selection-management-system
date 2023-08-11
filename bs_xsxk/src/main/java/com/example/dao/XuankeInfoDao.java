package com.example.dao;

import com.example.entity.XuankeInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface XuankeInfoDao extends Mapper<XuankeInfo> {

    @Select("SELECT * FROM xuanke_info WHERE studentId = #{ID}")
    XuankeInfo SelectByStudentId(@Param("ID") Long ID);
}
