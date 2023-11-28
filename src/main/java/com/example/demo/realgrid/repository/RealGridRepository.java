package com.example.demo.realgrid.repository;

import com.example.demo.realgrid.entity.RealGridEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository를 상속받아 기본적인 CRUD 기능을 제공하는 Repository
public interface RealGridRepository extends JpaRepository<RealGridEntity, String> {
    // JpaRepository를 상속하면 기본적인 CRUD(Create, Read, Update, Delete) 기능을 제공받을 수 있음
    // RealGridEntity: 엔터티 클래스의 타입
    // String: 엔터티의 식별자(ID)의 타입
    // (이 예제에서는 RealGridEntity 클래스가 String 타입의 ID를 가지고 있다고 가정)
    // JpaRepository를 상속받으면 별도의 구현 없이 데이터베이스 조작이 가능

    // JpaRepository 인터페이스를 상속받아서 별도의 메서드를 추가할 수도 있음
    // 추가적으로 필요한 데이터베이스 조회 메서드 등을 정의할 수 있음
}
