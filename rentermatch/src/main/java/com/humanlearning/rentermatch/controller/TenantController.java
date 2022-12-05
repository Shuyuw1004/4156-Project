package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Tenant;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.TenantMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("tenant")
@RestController
public class TenantController {

  private final static Logger LOGGER =
      Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  @Autowired
  private TenantMapper tenantMapper;
  @Autowired
  private ClientMapper clientMapper;

  @PostMapping("insertTenant")
  public ResponseEntity<String> insertTenant(Integer tAge, String tClientId, String tConstellation,
      String tCooking, String tEarlyTimeSleep, Integer tExpenditure, String tGender, String tJob,
      String tLateTimeSleep, Integer tNumOfRoomates, String tPet, String tPhone,
      String tPreferLocation, String tPreferType, String tPreferZipCode, String tSmoking) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    if (tAge == null) {
      return new ResponseEntity<>("tAge cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    if (tClientId == null || tClientId.isEmpty()) {
      return new ResponseEntity<>("tClientId cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tConstellation == null || tConstellation.isEmpty()) {
      return new ResponseEntity<>("tConstellation cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tCooking == null || tCooking.isEmpty()) {
      return new ResponseEntity<>("tCooking cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tEarlyTimeSleep == null || tEarlyTimeSleep.isEmpty()) {
      return new ResponseEntity<>("tEarlyTimeSleep cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tExpenditure == null) {
      return new ResponseEntity<>("tExpenditure cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tGender == null || tGender.isEmpty()) {
      return new ResponseEntity<>("tGender cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tJob == null || tJob.isEmpty()) {
      return new ResponseEntity<>("tJob cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    if (tLateTimeSleep == null || tLateTimeSleep.isEmpty()) {
      return new ResponseEntity<>("tLateTimeSleep cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tNumOfRoomates == null) {
      return new ResponseEntity<>("tNumOfRoomates cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tPet == null || tPet.isEmpty()) {
      return new ResponseEntity<>("tPet cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    if (tPhone == null || tPhone.isEmpty()) {
      return new ResponseEntity<>("tPhone cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tPreferLocation == null || tPreferLocation.isEmpty()) {
      return new ResponseEntity<>("tPreferLocation cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tPreferType == null || tPreferType.isEmpty()) {
      return new ResponseEntity<>("tPreferType cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tPreferZipCode == null || tPreferZipCode.isEmpty()) {
      return new ResponseEntity<>("tPreferZipCode cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (tSmoking == null || tSmoking.isEmpty()) {
      return new ResponseEntity<>("tSmoking cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    // check if tClientId in client database
    Client client = clientMapper.selectClientBycId(tClientId);
    if (client == null) {
      return new ResponseEntity<>("profile creation failed, tenant is not a client",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }
    Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
    if (tenant != null) {
      return new ResponseEntity<>("profile creation failed, tenant already exist", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    int resultCount = tenantMapper.saveTenant(tAge, tClientId, tConstellation, tCooking,
        tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, tNumOfRoomates, tPet, tPhone,
        tPreferLocation, tPreferType, tPreferZipCode, tSmoking);
    if (resultCount == 0) {
      return new ResponseEntity<>("profile creation failed, reason unknown", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>("profile creation successful", responseHeaders, HttpStatus.OK);
  }


  @GetMapping("getTenantBytId")
  public String getTenantBytId(String tId) {
    if (!tId.isEmpty()) {
      Tenant tenant = tenantMapper.selectTenantBytId(tId);
      if (tenant != null) {
        return tenant.toString();
      } else {
        return "tenant does not exist.";
      }
    } else {
      return "tId cannot be empty.";
    }
  }

  @GetMapping("getTenantBytClientId")
  public String getTenantByClientId(String tClientId) {
    if (!tClientId.isEmpty()) {
      Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
      if (tenant != null) {
        return tenant.toString();
      } else {
        return "tenant does not exist.";
      }
    } else {
      return "tClientId cannot be empty.";
    }
  }

  @PatchMapping("updateTenant")
  public String updateTenant(Integer tAge, String tClientId, String tConstellation,
      String tCooking, String tEarlyTimeSleep, Integer tExpenditure, String tGender, String tJob,
      String tLateTimeSleep, Integer tNumOfRoomates, String tPet, String tPhone,
      String tPreferLocation, String tPreferType, String tPreferZipCode, String tSmoking) {
    if (tAge == null) {
      return "tAge cannot be empty";
    }
    if (tClientId == null || tClientId.isEmpty()) {
      return "tClientId cannot be empty";
    }
    if (tConstellation == null || tConstellation.isEmpty()) {
      return "tConstellation cannot be empty";
    }
    if (tCooking == null || tCooking.isEmpty()) {
      return "tCooking cannot be empty";
    }
    if (tEarlyTimeSleep == null || tEarlyTimeSleep.isEmpty()) {
      return "tEarlyTimeSleep cannot be empty";
    }
    if (tExpenditure == null) {
      return "tExpenditure cannot be empty";
    }
    if (tGender == null || tGender.isEmpty()) {
      return "tGender cannot be empty";
    }
    if (tJob == null || tJob.isEmpty()) {
      return "tJob cannot be empty";
    }
    if (tLateTimeSleep == null || tLateTimeSleep.isEmpty()) {
      return "tLateTimeSleep cannot be empty";
    }
    if (tNumOfRoomates == null) {
      return "tNumOfRoomates cannot be empty";
    }
    if (tPet == null || tPet.isEmpty()) {
      return "tPet cannot be empty";
    }
    if (tPhone == null || tPhone.isEmpty()) {
      return "tPhone cannot be empty";
    }
    if (tPreferLocation == null || tPreferLocation.isEmpty()) {
      return "tPreferLocation cannot be empty";
    }
    if (tPreferType == null || tPreferType.isEmpty()) {
      return "tPreferType cannot be empty";
    }
    if (tPreferZipCode == null || tPreferZipCode.isEmpty()) {
      return "tPreferZipCode cannot be empty";
    }
    if (tSmoking == null || tSmoking.isEmpty()) {
      return "tSmoking cannot be empty";
    }
    Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
    if (tenant == null) {
      return "update failed, tenant does not exist";
    }
    int resultCount = tenantMapper.updateTenant(tAge, tClientId, tConstellation, tCooking,
        tEarlyTimeSleep,
        tExpenditure, tGender, tJob, tLateTimeSleep, tNumOfRoomates,
        tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking);
    if (resultCount == 0) {
      return "update failed";
    } else {
      return "tenant updated successfully";
    }
  }

  @DeleteMapping("deleteTenant")
  public String deleteTenant(String tClientId) {
    //Check whether tClientId is empty
    if (tClientId == null || tClientId.isEmpty()) {
      return "tClientId cannot be empty";
    }
    Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
    if (tenant == null) {
      return "tenant does not exist";
    }
    int resultCount = tenantMapper.deleteTenantBytClientId(tClientId);
    if (resultCount == 0) {
      return "delete failed";
    } else {
      return "tenant deleted successfully";
    }
  }

  @GetMapping("getMatch")
  public ResponseEntity<String> getMatch(String tClientId) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    if (tClientId == null || tClientId.isEmpty()) {
      return new ResponseEntity<>("tClientId cannot be empty", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
    if (tenant == null) {
      return new ResponseEntity<>("tenant does not exist", responseHeaders, HttpStatus.BAD_REQUEST);

    }
    String constellation = tenant.getTConstellation();
    String cooking = tenant.getTCooking();
    String tearlyTimeSleep = tenant.getTEarlyTimeSleep();
    Integer expenditure = tenant.getTExpenditure();
    String gender = tenant.getTGender();
    String job = tenant.getTJob();
    String lateTimeSleep = tenant.getTLateTimeSleep();
    Integer numOfRoomates = tenant.getTNumOfRoomates();
    String pet = tenant.getTPet();
    String preferLocation = tenant.getTPreferLocation();
    String preferType = tenant.getTPreferType();
    String preferZipCode = tenant.getTPreferZipCode();
    String smoking = tenant.getTSmoking();

    List<Tenant> matchedTenants = tenantMapper.getMatch(tClientId, constellation, cooking,
        tearlyTimeSleep,
        expenditure, gender, job, lateTimeSleep, numOfRoomates, pet,
        preferLocation, preferType, preferZipCode, smoking);
    if (matchedTenants == null || matchedTenants.isEmpty()) {
      return new ResponseEntity<>("cannot find matched tenants", responseHeaders,
          HttpStatus.INTERNAL_SERVER_ERROR);

    }
    StringBuilder tenants = new StringBuilder("");
    for (int i = 0; i < matchedTenants.size(); i++) {
      tenants.append(matchedTenants.get(i).toString());
      tenants.append("\n");
    }
    this.LOGGER.log(Level.INFO, "reach here");
    //send email
    return new ResponseEntity<>(tenant.toString(), responseHeaders, HttpStatus.OK);
  }

//    public ResponseEntity<String> sendEmail(String msg, HttpStatus status, String email_adr) {
//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("Access-Control-Allow-Origin", "*");
//        responseHeaders.set("Access-Control-Allow-Headers","X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
//        responseHeaders.set("Access-Control-Allow-Methods","GET, POST, OPTIONS, PUT, DELETE, PATCH");
//        String from = "4156_Group@gmail.com";
//        String host = "localhost";
//        Properties properties = System.getProperties();
//        properties.setProperty("mail.smtp.host", host);
//        Session session = Session.getDefaultInstance(properties);
//
//        try {
//            // Create a default MimeMessage object.
//            MimeMessage message = new MimeMessage(session);
//
//            // Set From: header field of the header.
//            message.setFrom(new InternetAddress(from));
//
//            // Set To: header field of the header.
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_adr));
//
//            // Set Subject: header field
//            message.setSubject("Your Matching result is Here!");
//
//            // Now set the actual message
//            message.setText(msg);
//
//            // Send message
//            this.LOGGER.log(Level.INFO, "reach here");
//            Transport.send(message);
//            System.out.println("Sent message successfully....");
//        } catch (MessagingException mex) {
//            mex.printStackTrace();
//        }
//        return new ResponseEntity<>("success", responseHeaders, status);
//    }
}
