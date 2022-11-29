package com.humanlearning.rentermatch;


import org.junit.jupiter.api.Test;

// Test class added ONLY to cover main() invocation not covered by application tests.
public class RentermatchApplicationTests {
  @Test
  public void main() {
    RentermatchApplication.main(new String[] {});
  }
}
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//import com.humanlearning.rentermatch.controller.ClientController;
//import com.humanlearning.rentermatch.domain.Client;
//import com.humanlearning.rentermatch.mapper.ClientMapper;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
//
//@SpringBootTest(classes = RentermatchApplication.class,
//    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class RentermatchApplicationTests {
//
//  @Autowired
//  private ClientController clientController;
//
//  String testName="jk";
//
//  String testEmail="jk@gmail.com";
//
//  String realEmail="kevinceltics09@hotmail.com";
//
//  String testPassword="jkpassword";
//
//  String wrongPassword="wrongpassword";
//
//
//  @Test
//  void testSuccessRegister() {
//    // test success register
//    Client client = new Client();
//
//    client.setEmail(testEmail);
//    client.setName(testName);
//    client.setPassword(testPassword);
//
//    ResponseEntity<String> responseEntity = clientController.register(client.getPassword(),
//        client.getName(), client.getEmail());
//
//    assertEquals("register successfully", responseEntity.getBody());
//
//  }
//
//  @Test
//  void testDuplicateRegister() {
//    // test duplicate register
//    Client client = new Client();
//
//    client.setEmail(testEmail);
//    client.setName(testName);
//    client.setPassword(testPassword);
//
//    ResponseEntity<String> responseEntity = clientController.register(client.getPassword(),
//        client.getName(), client.getEmail());
//
//    assertEquals("register fail, user already exist", responseEntity.getBody());
//  }
//
//  @Test
//  void testSuccessfulLogin() {
//    // test successful login
//    Client client = new Client();
//
//    client.setEmail(testEmail);
//    client.setPassword(testPassword);
//
//    String result = clientController.login(client.getEmail(), client.getPassword());
//
//    assertEquals("login successfully", result);
//  }
//
//  @Test
//  void testWrongPasswordLogin() {
//    // test wrong password login
//    Client client = new Client();
//
//    client.setEmail(testEmail);
//    client.setPassword(wrongPassword);
//
//    String result = clientController.login(client.getEmail(), client.getPassword());
//
//    assertEquals("wrong password", result);
//  }
//
//  @Test
//  void testGetClientSuccessfully(){
//    //test get client by email
//    Client client = new Client();
//
//    client.setEmail(realEmail);
//    client.setName(testName);
//    client.setPassword(wrongPassword);
//
//    String result = clientController.getClientByEmail(client.getEmail());
//
//    assertEquals("Client(cid=1, name=Lena Smith, password=123, email=kevinceltics09@hotmail.com)", result);
//  }
//
//
//}
