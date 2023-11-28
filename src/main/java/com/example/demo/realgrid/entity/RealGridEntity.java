package com.example.demo.realgrid.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // JPA 엔터티를 나타내는 클래스
@Table(name = "VUE_USERINFO") // 데이터베이스 테이블과 매핑될 테이블 이름 지정
public class RealGridEntity {

    @Id // 엔터티의 식별자(ID)를 나타내는 필드 아래는 나머지 필드들(각각의 데이터베이스 컬럼과 매핑됨)
    @Getter @Setter
    private String EMAIL;

    @Getter @Setter
    private String INPDATE;

    @Getter @Setter
    private String INP_USR;

    @Getter @Setter
    private String NICKNAME;
}
