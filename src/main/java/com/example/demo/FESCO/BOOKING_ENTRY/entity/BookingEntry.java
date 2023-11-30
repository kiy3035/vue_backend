// BookingEntry.java

package com.example.demo.FESCO.BOOKING_ENTRY.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TC_CODE_DTL") // 데이터베이스 테이블과 매핑될 테이블 이름 지정
public class BookingEntry {

    @Id
    @Getter @Setter
    private String code_cd;

    @Getter @Setter
    private String clss_cd;

    @Getter @Setter
    private String code_nm;

    // Add other fields as needed

    // Constructors, getters, setters
}
