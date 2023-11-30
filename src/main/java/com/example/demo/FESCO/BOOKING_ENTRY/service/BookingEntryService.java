package com.example.demo.FESCO.BOOKING_ENTRY.service;

import java.util.List;

import com.example.demo.FESCO.BOOKING_ENTRY.dto.BookingEntryDto;

public interface BookingEntryService {
    List<BookingEntryDto> getAllDataDto();

    List<BookingEntryDto> getDataDtoByClssCd(String clssCd);
}
