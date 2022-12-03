package com.humanlearning.rentermatch.domain;

import lombok.Data;

@Data
public class House {

  private String hId;
  private String hAddress;
  private Integer hPrice;
  private String hType;
  private String hLandlordId;
}
