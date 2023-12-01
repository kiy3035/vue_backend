package com.example.demo.FESCO.LOGIN.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.FESCO.LOGIN.entity.F_LoginEntity;


@Repository
public interface F_LoginRepository extends JpaRepository<F_LoginEntity, String> {

    @Query("SELECT COUNT(e) FROM F_LoginEntity e WHERE e.usr_cd = :usrCd AND e.usr_pw = :usrPw")
    int countByUsrCdAndUsrPw(@Param("usrCd") String usr_cd, @Param("usrPw") String usr_pw);
}
