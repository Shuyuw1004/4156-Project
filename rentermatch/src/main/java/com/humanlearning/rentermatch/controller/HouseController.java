package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.House;
import com.humanlearning.rentermatch.domain.Landlord;
import com.humanlearning.rentermatch.mapper.HouseMapper;
import com.humanlearning.rentermatch.mapper.LandlordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("house")
@RestController
public class HouseController {

    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private LandlordMapper landlordMapper;

    @PostMapping("insertHouse")
    public String insertHouse(String hAddress, Integer hPrice, String hType, String hLandlordId) {
        //Check whether hAddress is empty
        if (hAddress == null || hAddress.isEmpty()) {
            return "hAddress cannot be empty";
        }
        //Check whether hPrice is empty
        if (hPrice == null) {
            return "hPrice cannot be empty";
        }
        //Check whether hType is empty
        if (hType == null || hType.isEmpty()) {
            return "hType cannot be empty";
        }
        //Check whether hLandlordId is empty
        if (hLandlordId == null || hLandlordId.isEmpty()) {
            return "hLandlordId cannot be empty";
        }
        // check if hLandlordId exists in landlord database
        Landlord landlord = landlordMapper.selectLandlordBylId(hLandlordId);
        if (landlord == null) {
            return "house creation failed, landlord of the house does not exist";
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

    @PatchMapping("updateHousePrice")
    public String updateHouse(String hAddress, Integer hPrice) {
        //Check whether hAddress is empty
        if (hAddress == null || hAddress.isEmpty()) {
            return "hAddress cannot be empty";
        }
        //Check whether hPrice is empty
        if (hPrice == null) {
            return "hPrice cannot be empty";
        }
        House house = houseMapper.selectHouse(hAddress);
        if (house == null) {
            return "house does not exist";
        }
        int resultCount = houseMapper.updateHousePrice(hAddress, hPrice);
        if (resultCount == 0) {
            return "update failed";
        }
        else
            return "update successfully";
    }

    @DeleteMapping("deleteHouse")
    public String deleteHouse(String hAddress) {
        //Check whether hAddress is empty
        if (hAddress == null || hAddress.isEmpty()) {
            return "hAddress cannot be empty";
        }
        House house = houseMapper.selectHouse(hAddress);
        if (house == null) {
            return "house does not exist";
        }
        int resultCount = houseMapper.deleteHouseByhAddress(hAddress);
        if (resultCount == 0) {
            return "delete failed";
        }
        else
            return "house deleted successfully";
    }

}
