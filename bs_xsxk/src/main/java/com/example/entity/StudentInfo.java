package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="student_info")
public class StudentInfo extends Account {
    @Column(name = "code")//学号
    private String code;
    @Column(name = "xueyuanId")//学院id
    private Long xueyuanId;
    @Column(name = "score")//总学分
    private Integer score;

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
}
