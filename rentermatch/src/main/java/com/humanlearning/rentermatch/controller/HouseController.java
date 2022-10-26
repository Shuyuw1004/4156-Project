package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.House;
import com.humanlearning.rentermatch.mapper.HouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("house")
@RestController
public class HouseController {

    @Autowired
    private HouseMapper houseMapper;

    @GetMapping("insertHouse")
    public String insertHouse(String hAddress, Integer hPrice, String hType, Integer hLandlordId) {
        //Check whether hAddress is empty
        if (StringUtils.isEmpty(hAddress)) {
            return "hAddress cannot be empty";
        }
        //Check whether hPrice is empty
        if (StringUtils.isEmpty(hPrice)) {
            return "hPrice cannot be empty";
        }
        //Check whether hType is empty
        if (StringUtils.isEmpty(hType)) {
            return "hType cannot be empty";
        }
        //Check whether hLandlordId is empty
        if (StringUtils.isEmpty(hLandlordId)) {
            return "hLandlordId cannot be empty";
        }
        //Select house from database by hAddress
        House house = houseMapper.selectHouse(hAddress);
        //If house does not exist
        if (house != null) {
            return "house creation failed, house already exist";
        }
        int resultCount = houseMapper.saveHouse(hAddress, hPrice, hType, hLandlordId);
        if (resultCount == 0) return "house creation failed";
        return "house created successfully";
    }
}
