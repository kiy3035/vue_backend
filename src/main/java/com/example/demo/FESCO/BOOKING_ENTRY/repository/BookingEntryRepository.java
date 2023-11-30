package com.example.demo.FESCO.BOOKING_ENTRY.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.FESCO.BOOKING_ENTRY.entity.BookingEntry;

// JpaRepository를 상속받아 기본적인 CRUD 기능을 제공하는 Repository
@Repository
public interface BookingEntryRepository extends JpaRepository<BookingEntry, String> {
    // List<BookingEntry> findByClss_cd(String clssCd);
    @Query("SELECT b FROM BookingEntry b WHERE b.clss_cd = :clssCd")
    List<BookingEntry> findByClss_cd(@Param("clssCd") String clssCd);

}
