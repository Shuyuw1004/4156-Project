package com.humanlearning.rentermatch.domain;

import java.util.List;
import lombok.Data;

@Data
public class Tenant {

  private String tid;
  private Integer tAge;
  private String tClientId;
  private String tConstellation;
  private String tCooking;
  private String tEarlyTimeSleep;
  private Integer tExpenditure;
  private String tGender;
  private String tJob;
  private String tLateTimeSleep;
  private List<String> tMatches;
  private Integer tNumOfRoomates;
  private String tPet;
  private String tPhone;
  private String tPreferLocation;
  private String tPreferType;
  private String tPreferZipCode;
  private String tSmoking;
}
