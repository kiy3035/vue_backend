package com.example.demo.FESCO.LOGIN.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TCMN_USR_MST")
public class F_LoginEntity {

    @Id
    @Getter @Setter
    private String usr_cd;

    @Getter @Setter
    private String usr_pw;
}
