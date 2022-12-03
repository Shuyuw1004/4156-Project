package com.humanlearning.rentermatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@MapperScan("com.humanlearning.rentermatch.mapper")
@SpringBootApplication
public class RentermatchApplication {

  public static void main(String[] args) {
    SpringApplication.run(RentermatchApplication.class, args);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }
}
