package com.example.demo.FESCO.TEST.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "MIG_TADJ_ARAP_DTL")
public class TestDtlEntity {

    @Getter
    @Setter
    @Column(name = "ARAP_NO")
    private String arap_no;

    @Getter @Setter
    @Column(name = "COM_CD")
    @Id
    private String com_cd;
    
    // @ManyToOne
    // @JoinColumn(name = "ARAP_NO", referencedColumnName = "ARAP_NO", insertable = false, updatable = false)
    // private TestMstEntity testMstEntity;

}
