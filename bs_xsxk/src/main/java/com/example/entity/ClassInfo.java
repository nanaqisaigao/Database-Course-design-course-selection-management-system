package com.example.entity;

import javax.persistence.*;

@Table(name="class_info")
public class ClassInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "score")
    private int score;
    @Column(name = "kaiban")
    private int kaiban;
    @Column(name = "time")
    private String time;
    @Column(name = "location")
    private String location;
    @Column(name = "yixuan")
    private int yixuan;
    //下面两个属性分别和教师模块，学生模块关联
    @Column(name = "teacherId")
    private int teacherId;
    @Column(name = "zhuanyeId")
    private Long zhuanyeId;
    @Transient
    private String teacherName;
    @Transient
    private String zhuanyeName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getKaiban() {
        return kaiban;
    }

    public void setKaiban(int kaiban) {
        this.kaiban = kaiban;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYixuan() {
        return yixuan;
    }

    public void setYixuan(int yixuan) {
        this.yixuan = yixuan;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public Long getZhuanyeId() {
        return zhuanyeId;
    }

    public void setZhuanyeId(Long zhuanyeId) {
        this.zhuanyeId = zhuanyeId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getZhuanyeName() {
        return zhuanyeName;
    }

    public void setZhuanyeName(String zhuanyeName) {
        this.zhuanyeName = zhuanyeName;
    }
}
