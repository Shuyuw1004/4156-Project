package com.humanlearning.rentermatch.domain;

import lombok.Data;

@Data
public class House {
    private Integer hId;
    private String hAddress;
    private Integer hPrice;
    private String hType;
    private Integer hLandlordId;
}
