package com.example.demo.msisdn.controller;

import com.example.demo.msisdn.domain.MobileNumber;
import com.example.demo.msisdn.service.MobileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/api/msisdn")
public class MobileNumberFormatController {

    @Autowired
    private MobileService mobileService;

    @PostMapping(value ="/mobile-numbers")
    private MobileNumber getValidMobileNumbers(@RequestBody MobileNumber mobileNumberDto) {
        return mobileService.getValidMobileNumbers(mobileNumberDto);
    }
}
