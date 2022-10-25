package com.humanlearning.rentermatch.domain;

import lombok.Data;

@Data
public class Student {
    private String email;
    private String name;
    private Integer sid;
    private Integer sClientId;
    private String uni;
}
