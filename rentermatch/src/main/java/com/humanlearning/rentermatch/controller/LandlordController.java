package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Landlord;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.LandlordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("landlord")
@RestController
public class LandlordController {

    @Autowired
    private LandlordMapper landlordMapper;
    @Autowired
    private ClientMapper clientMapper;

    @PostMapping("insertLandlord")
    public String insertLandlord(String lPhone, Integer lClientId) {
        //Check whether lPhone is empty
        if (StringUtils.isEmpty(lPhone)) {
            return "lPhone cannot be empty";
        }
        //Check whether lClientid is empty
        if (StringUtils.isEmpty(lClientId)) {
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
    public String updateLandlord(String lPhone, Integer lClientId) {
        //Check whether lPhone is empty
        if (lPhone == null) {
            return "lPhone cannot be empty";
        }
        //Check whether lClientid is empty
        if (lClientId == null) {
            return "lClientId cannot be empty";
        }
        //Select landlord from database by lPhone
        Landlord landlord = landlordMapper.selectLandlordBylClientId(lClientId);

        if (landlord == null) {
            return "landlord does not exist";
        }
        Integer lId = landlord.getLId();
        int resultCount = landlordMapper.updateLandlord(lPhone, lClientId, lId);
        if(resultCount == 0) {
            return "update failed";
        }
        else
            return "update successfully";
    }

    @DeleteMapping("deleteLandlord")
    public String deleteLandlord(String lPhone, Integer lClientId) {
        //Check whether lPhone is empty
        if (lPhone == null) {
            return "lPhone cannot be empty";
        }
        //Check whether lClientid is empty
        if (lClientId == null) {
            return "lClientId cannot be empty";
        }
        //Select landlord from database by lPhone
        Landlord landlord = landlordMapper.selectLandlordBylClientId(lClientId);

        if (landlord == null) {
            return "landlord does not exist";
        }
        Integer lId = landlord.getLId();
        int resultCount = landlordMapper.deleteLandlordBylId(lId);
        if (resultCount == 0) {
            return "delete failed";
        }
        else
            return "delete successfully";
    }
}
