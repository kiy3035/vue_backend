package com.example.demo.FESCO.TEST.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.FESCO.TEST.entity.TestMstEntity;


@Repository
public interface TestRepository extends JpaRepository<TestMstEntity, String> {

    @Query("SELECT m FROM TestMstEntity m JOIN m.testDtlEntity d ON m.arap_no = d.arap_no WHERE m.arap_no = :arapNo")
    List<TestMstEntity> findByArapNo(@Param("arapNo") String arapNo);
    
}
