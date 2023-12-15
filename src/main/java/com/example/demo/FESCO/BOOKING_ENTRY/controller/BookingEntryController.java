package com.example.demo.FESCO.BOOKING_ENTRY.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FESCO.BOOKING_ENTRY.dto.BookingEntryDto;
import com.example.demo.FESCO.BOOKING_ENTRY.service.BookingEntryService;


@RestController
public class BookingEntryController {

    @Autowired
    private BookingEntryService bookingEntryService;

    @GetMapping("/{clssCd}")
    @ResponseBody
    public List<BookingEntryDto> searchData(@PathVariable String clssCd) {
        return null;
        // return bookingEntryService.getDataDtoByClssCd(clssCd);
    }
}
