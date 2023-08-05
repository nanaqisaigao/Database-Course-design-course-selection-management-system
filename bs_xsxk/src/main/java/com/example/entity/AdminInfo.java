package com.example.entity;

import javax.persistence.*;

@Table(name="admin_info")
public class AdminInfo extends Account {
    @Column(name = "phone")
    private String phone;
}
