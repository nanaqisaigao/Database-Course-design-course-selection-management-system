package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name="teacher_info")
public class TeacherInfo extends Account {
    @Column(name = "zhicheng")
    private String zhicheng;
    @Column(name = "zhuanyeId")
    private Long zhuanyeId;
    @Transient
    private String zhuanyeName;

    public String getZhuanyeName() {
        return zhuanyeName;
    }

    public void setZhuanyeName(String zhuanyeName) {
        this.zhuanyeName = zhuanyeName;
    }

    public String getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }

    public Long getZhuanyeId() {
        return zhuanyeId;
    }

    public void setZhuanyeId(Long zhuanyeId) {
        this.zhuanyeId = zhuanyeId;
    }
}
