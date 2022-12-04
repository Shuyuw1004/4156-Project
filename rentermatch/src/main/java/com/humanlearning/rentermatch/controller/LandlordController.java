package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Landlord;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.HouseMapper;
import com.humanlearning.rentermatch.mapper.LandlordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  public ResponseEntity<String> insertLandlord(String lPhone, String lClientId) {
    //Check whether lPhone is empty
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    if (lPhone == null || lPhone.isEmpty()) {
      return new ResponseEntity<>("lPhone cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Check whether lClientid is empty
    if (lClientId == null || lClientId.isEmpty()) {
      return new ResponseEntity<>("lClientId cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    // check if landlord exist in client database
    Client client = clientMapper.selectClientBycId(lClientId);
    if (client == null) {
      return new ResponseEntity<>("landlord creation failed, landlord is not a client",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }
    //Select landlord from database by lClientId
    Landlord landlord = landlordMapper.selectLandlordBylClientId(lClientId);
    //If landlord does not exist
    if (landlord != null) {
      return new ResponseEntity<>("landlord creation failed, landlord already exist",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }
    int resultCount = landlordMapper.saveLandlord(lPhone, lClientId);
    if (resultCount == 0) {
      return new ResponseEntity<>("landlord creation failed", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("landlord created successfully", responseHeaders, HttpStatus.OK);
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
    if (resultCount == 0) {
      return "update failed";
    } else {
      return "update successfully";
    }
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
    } else {
      return "delete successfully";
    }
  }
}
