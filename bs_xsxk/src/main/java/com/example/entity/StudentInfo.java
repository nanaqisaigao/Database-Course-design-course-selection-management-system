package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="student_info")
public class StudentInfo extends Account {
    @Column(name = "code")//学号
    private String code;
    @Column(name = "xueyuanId")//学院id
    private Long xueyuanId;
    @Column(name = "score")//总学分
    private Integer score;
    //先在学生信息实体类中定义一个xueyuanName变量，用于存储根据学生数据库的学院id在学院数据库中查找到的学院名称
    @Transient//代表这个变量不是数据库中的属性
    private String xueyuanName;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getXueyuanId() {
        return xueyuanId;
    }

    public void setXueyuanId(Long xueyuanId) {
        this.xueyuanId = xueyuanId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getXueyuanName() {
        return xueyuanName;
    }

    public void setXueyuanName(String xueyuanName) {
        this.xueyuanName = xueyuanName;
    }
}
