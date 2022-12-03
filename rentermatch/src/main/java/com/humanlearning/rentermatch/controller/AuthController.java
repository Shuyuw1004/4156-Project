package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.model.JwtRequest;
import com.humanlearning.rentermatch.model.JwtResponse;
import com.humanlearning.rentermatch.service.UserService;
import com.humanlearning.rentermatch.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

  @Autowired
  private JWTUtility jwtUtility;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserService userService;


  @PostMapping("/authenticate")
  public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(
              jwtRequest.getUsername(),
              jwtRequest.getPassword()
          )
      );
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }

    final UserDetails userDetails
        = userService.loadUserByUsername(jwtRequest.getUsername());

    final String token =
        jwtUtility.generateToken(userDetails);

    return new JwtResponse(token);
  }
}
