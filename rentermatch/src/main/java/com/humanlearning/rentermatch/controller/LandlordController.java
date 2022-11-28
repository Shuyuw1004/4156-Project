package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Landlord;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.HouseMapper;
import com.humanlearning.rentermatch.mapper.LandlordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("landlord")
@RestController
public class LandlordController {

    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private ClientMapper clientMapper;

    @Autowired
    private HouseMapper houseMapper;

    @PostMapping("insertLandlord")
    public String insertLandlord(String lPhone, String lClientId) {
        //Check whether lPhone is empty
        if (lPhone == null || lPhone.isEmpty()) {
            return "lPhone cannot be empty";
        }
        //Check whether lClientid is empty
        if (lClientId == null || lClientId.isEmpty()) {
            return "lClientId cannot be empty";
        }
        // check if landlord exist in client database
        Client client = clientMapper.selectClientBycId(lClientId);
        if (client == null) {
            return "landlord creation failed, landlord is not a client";
        }
        //Select landlord from database by lClientId
        Landlord landlord = landlordMapper.selectLandlordBylClientId(lClientId);
        //If landlord does not exist
        if (landlord != null) {
            return "landlord creation failed, landlord already exist";
        }
        int resultCount = landlordMapper.saveLandlord(lPhone, lClientId);
        if (resultCount == 0) return "landlord creation failed";
        return "landlord created successfully";
    }

    @PatchMapping("updateLandlord")
    public String updateLandlord(String lPhone, String lClientId) {
        //Check whether lPhone is empty
        if (lPhone == null || lPhone.isEmpty()) {
            return "lPhone cannot be empty";
        }
        //Check whether lClientid is empty
        if (lClientId == null || lClientId.isEmpty()) {
            return "lClientId cannot be empty";
        }
        //Select landlord from database by lClientId
        Landlord landlord = landlordMapper.selectLandlordBylClientId(lClientId);

        if (landlord == null) {
            return "landlord does not exist";
        }
        int resultCount = landlordMapper.updateLandlord(lPhone, lClientId);
        if(resultCount == 0) {
            return "update failed";
        }
        else
            return "update successfully";
    }

    @DeleteMapping("deleteLandlord")
    public String deleteLandlord(String lClientId) {
        //Check whether lClientid is empty
        if (lClientId == null || lClientId.isEmpty()) {
            return "lClientId cannot be empty";
        }
        //Select landlord from database by lClientId
        Landlord landlord = landlordMapper.selectLandlordBylClientId(lClientId);

        if (landlord == null) {
            return "landlord does not exist";
        }
        // delete the houses owned by landlord
        String lid = landlord.getLId();
        int deleteHouse = houseMapper.deleteHouseByhLandlordId(lid);

        int resultCount = landlordMapper.deleteLandlordBylClientId(lClientId);
        if (resultCount == 0) {
            return "delete failed";
        }
        else
            return "delete successfully";
    }
}
