package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.House;
import com.humanlearning.rentermatch.domain.Landlord;
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
@RequestMapping("house")
@RestController
public class HouseController {

  @Autowired
  private HouseMapper houseMapper;
  @Autowired
  private LandlordMapper landlordMapper;
  final static String emptyAddr = "hAddress cannot be empty";

  @PostMapping("insertHouse")
  public ResponseEntity<String> insertHouse(String hAddress, Integer hPrice, String hType,
      String hLandlordId) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    //Check whether hAddress is empty
    if (hAddress == null || hAddress.isEmpty()) {
      return new ResponseEntity<>(emptyAddr, responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Check whether hPrice is empty
    if (hPrice == null) {
      return new ResponseEntity<>("hPrice cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Check whether hType is empty
    if (hType == null || hType.isEmpty()) {
      return new ResponseEntity<>("hType cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    //Check whether hLandlordId is empty
    if (hLandlordId == null || hLandlordId.isEmpty()) {
      return new ResponseEntity<>("hLandlordId cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    // check if hLandlordId exists in landlord database
    Landlord landlord = landlordMapper.selectLandlordBylId(hLandlordId);
    if (landlord == null) {
      return new ResponseEntity<>("house creation failed, landlord of the house does not exist",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }

    //Select house from database by hAddress
    House house = houseMapper.selectHouse(hAddress);
    //If house does not exist
    if (house != null) {
      return new ResponseEntity<>("house creation failed, house already exist", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    int resultCount = houseMapper.saveHouse(hAddress, hPrice, hType, hLandlordId);
    if (resultCount == 0) {
      return new ResponseEntity<>("house creation failed", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("house created successfully", responseHeaders, HttpStatus.OK);
  }

  @PatchMapping("updateHousePrice")
  public ResponseEntity<String> updateHouse(String hAddress, Integer hPrice) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    //Check whether hAddress is empty
    if (hAddress == null || hAddress.isEmpty()) {
      return new ResponseEntity<>(emptyAddr, responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Check whether hPrice is empty
    if (hPrice == null) {
      return new ResponseEntity<>("hPrice cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);

    }
    House house = houseMapper.selectHouse(hAddress);
    if (house == null) {
      return new ResponseEntity<>("house does not exist", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    int resultCount = houseMapper.updateHousePrice(hAddress, hPrice);
    if (resultCount == 0) {
      return new ResponseEntity<>("update failed", responseHeaders, HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity<>("update successfully", responseHeaders, HttpStatus.OK);
    }
  }

  @DeleteMapping("deleteHouse")
  public String deleteHouse(String hAddress) {
    //Check whether hAddress is empty
    if (hAddress == null || hAddress.isEmpty()) {
      return emptyAddr;
    }
    House house = houseMapper.selectHouse(hAddress);
    if (house == null) {
      return "house does not exist";
    }
    int resultCount = houseMapper.deleteHouseByhAddress(hAddress);
    if (resultCount == 0) {
      return "delete failed";
    } else {
      return "house deleted successfully";
    }
  }

}
