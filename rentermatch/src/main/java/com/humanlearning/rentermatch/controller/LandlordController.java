package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Landlord;
import com.humanlearning.rentermatch.mapper.LandlordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("landlord")
@RestController
public class LandlordController {

    @Autowired
    private LandlordMapper landlordMapper;

    @GetMapping("insertLandlord")
    public String insertLandlord(String lPhone, Integer lClientId) {
        //Check whether lPhone is empty
        if (StringUtils.isEmpty(lPhone)) {
            return "lPhone cannot be empty";
        }
        //Check whether lClientid is empty
        if (StringUtils.isEmpty(lClientId)) {
            return "lClientId cannot be empty";
        }
        //Select client from database by email
        Landlord landlord = landlordMapper.selectLandlord(lPhone);
        //If client does not exist
        if (landlord != null) {
            return "landlord creation failed, user already exist";
        }
        int resultCount = landlordMapper.saveLandlord(lPhone, lClientId);
        if (resultCount == 0) return "profile creation failed";
        return "profile created successfully";
    }
}
