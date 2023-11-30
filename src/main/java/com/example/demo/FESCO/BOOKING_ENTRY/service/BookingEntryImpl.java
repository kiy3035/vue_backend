// BookingEntryServiceImpl.java

package com.example.demo.FESCO.BOOKING_ENTRY.service;

import com.example.demo.FESCO.BOOKING_ENTRY.dto.BookingEntryDto;
import com.example.demo.FESCO.BOOKING_ENTRY.entity.BookingEntry;
import com.example.demo.FESCO.BOOKING_ENTRY.repository.BookingEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingEntryImpl implements BookingEntryService {

    @Autowired
    private BookingEntryRepository bookingEntryRepository;

    @Override
    public List<BookingEntryDto> getAllDataDto() {
        List<BookingEntry> bookingEntries = bookingEntryRepository.findAll();
        return bookingEntries.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingEntryDto> getDataDtoByClssCd(String clssCd) {
        List<BookingEntry> bookingEntries = bookingEntryRepository.findByClss_cd(clssCd);
        return bookingEntries.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private BookingEntryDto convertToDto(BookingEntry bookingEntry) {
        BookingEntryDto dto = new BookingEntryDto();
        dto.setCode_cd(bookingEntry.getCode_cd());
        dto.setClss_cd(bookingEntry.getClss_cd());
        dto.setCode_nm(bookingEntry.getCode_nm());
        // Map other fields as needed
        return dto;
    }
}
