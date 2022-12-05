package com.humanlearning.rentermatch.controller;
//

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Landlord;
import com.humanlearning.rentermatch.domain.Student;
import com.humanlearning.rentermatch.domain.Tenant;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.LandlordMapper;
import com.humanlearning.rentermatch.mapper.StudentMapper;
import com.humanlearning.rentermatch.mapper.TenantMapper;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("client")
@RestController
public class ClientController {

  @Autowired
  private ClientMapper clientMapper;
  @Autowired
  private LandlordMapper landlordMapper;
  @Autowired
  private StudentMapper studentMapper;
  @Autowired
  private TenantMapper tenantMapper;

  @PostMapping("login")
  public ResponseEntity<String> login(String email, String password) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    //Check whether email is empty
    if (email == null || email.isEmpty()) {
      return new ResponseEntity<>("email cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    //Check whether password is empty
    if (password == null || password.isEmpty()) {
      return new ResponseEntity<>("password cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Select client from database by email
    Client client = clientMapper.selectClient(email);
    //If client does not exist
    if (client == null) {
      return new ResponseEntity<>("no email associated", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    //Check whether the password matches the one stored in database
    if (password.equals(client.getPassword())) {
      return new ResponseEntity<>(String.format("%s",
          clientMapper.selectClient(email).getCid()), responseHeaders, HttpStatus.OK);
    }
    return new ResponseEntity<>("wrong password", responseHeaders, HttpStatus.BAD_REQUEST);
  }


  @PostMapping("register")
  public ResponseEntity<String> register(String password, String name, String email) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    //Check whether email is empty
    if (email == null || email.isEmpty()) {
      return new ResponseEntity<>("register fail, email cannot be empty!", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Check whether password is empty
    if (password == null || password.isEmpty()) {
      return new ResponseEntity<>("register fail, password cannot be empty!", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (!password.matches("^(?=.*[A-Za-z0-9])(?=.*)[A-Za-z0-9]{8,}$")) {
      return new ResponseEntity<>(
          "register fail, password must contain minimum eight characters, at least one letter and one number!",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }
    //Check whether name is empty
    if (name == null || name.isEmpty()) {
      return new ResponseEntity<>("register fail, name cannot be empty!", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (name.length() > 64) {
      return new ResponseEntity<>("register fail, name cannot exceed 64 characters!",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }
    //Select client from database by email
    Client client = clientMapper.selectClient(email);
    //Check whether client already exist
    if (client != null) {
      return new ResponseEntity<>("register fail, user already exist!", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    //Return 1 if saved successfully; return 0 if failed
    int resultCount = clientMapper.saveClient(password, name, email);
    if (resultCount == 0) {
      return new ResponseEntity<>("register fail, reason unknown!", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(String.format("%s",
        clientMapper.selectClient(email).getCid()), responseHeaders, HttpStatus.OK);
  }


  @GetMapping("getClientByEmail")
  public String getClientByEmail(String email) {
    if (email != null && !email.isEmpty()) {
      Client client = clientMapper.selectClientByEmail(email);
      if (client != null) {
        return client.toString();
      } else {
        return "The client does not exist.";
      }
    } else {
      return "Email cannot be empty.";
    }
  }

  @GetMapping("getClientBycId")
  public String getClientBycId(String cid) {
    if (cid != null && !cid.isEmpty()) {
      Client client = clientMapper.selectClientBycId(cid);
      if (client != null) {
        return client.toString();
      } else {
        return "The client does not exist.";
      }
    } else {
      return "cId cannot be empty.";
    }
  }

  @DeleteMapping("deleteClient")
  public String deleteClient(String password, String name, String email) {
    if (password == null || password.isEmpty()) {
      return "password cannot be empty";
    }
    if (name == null || name.isEmpty()) {
      return "name cannot be empty";
    }
    if (email == null || email.isEmpty()) {
      return "email cannot be empty";
    }
    Client client = clientMapper.selectClient(email);
    if (client == null) {
      return "client doest not exist";
    }
    String cid = client.getCid();
    // if client is a landlord, delete landlord first
    Landlord landlord = landlordMapper.selectLandlordBylClientId(cid);
    if (landlord != null) {
      int resultCount = landlordMapper.deleteLandlordBylClientId(cid);
      if (resultCount == 0) {
        return "delete the client as a landlord failed";
      }
    }
    // if client is a student, delete student first
    Student student = studentMapper.selectStudentBysClientId(cid);
    if (student != null) {
      int resultCount = studentMapper.deleteStudentBysClientId(cid);
      if (resultCount == 0) {
        return "delete the client as a student failed";
      }
    }
    // if client is a tenant, delete tenant first
    Tenant tenant = tenantMapper.selectTenantBytClientId(cid);
    if (tenant != null) {
      int resultCount = tenantMapper.deleteTenantBytClientId(cid);
      if (resultCount == 0) {
        return "delete the client as a tenant failed";
      }
    }
    int resultCount = clientMapper.deleteClientBycId(cid);
    if (resultCount == 0) {
      return "delete failed";
    } else {
      return "client deleted successfully";
    }
  }
}
