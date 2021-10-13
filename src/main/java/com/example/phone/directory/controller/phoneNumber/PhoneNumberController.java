package com.example.phone.directory.controller.phoneNumber;

import com.example.phone.directory.dto.phone.PhoneNumberDTO;
import com.example.phone.directory.service.phoneNumber.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "phoneNumber")
public class PhoneNumberController {

    @Autowired
    PhoneNumberService phoneNumberService;

    @RequestMapping(method = RequestMethod.GET)
    public List<PhoneNumberDTO> getAllPhoneNumbers(){
        return phoneNumberService.getAllPhoneNumbers();
    }

}
