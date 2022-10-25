package com.humanlearning.rentermatch.domain;

import lombok.Data;

@Data
public class Client {

  private Integer cid;
  private String name;
  private String password;
  private String email;
}
