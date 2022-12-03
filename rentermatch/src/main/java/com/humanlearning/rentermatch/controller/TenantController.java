package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Tenant;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.TenantMapper;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private TenantMapper tenantMapper;
  @Autowired
  private ClientMapper clientMapper;

  @PostMapping("insertTenant")
  public String insertTenant(Integer tAge, String tClientId, String tConstellation,
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
    // check if tClientId in client database
    Client client = clientMapper.selectClientBycId(tClientId);
    if (client == null) {
      return "profile creation failed, tenant is not a client";
    }
    Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
    if (tenant != null) {
      return "profile creation failed, tenant already exist";
    }
    int resultCount = tenantMapper.saveTenant(tAge, tClientId, tConstellation, tCooking,
        tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, tNumOfRoomates, tPet, tPhone,
        tPreferLocation, tPreferType, tPreferZipCode, tSmoking);
    if (resultCount == 0) {
      return "tenant profile creation failed";
    }
    return "tenant profile created successfully";
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
  public String getMatch(String tClientId) {
    if (tClientId == null || tClientId.isEmpty()) {
      return "tClientId cannot be empty";
    }
    Tenant tenant = tenantMapper.selectTenantBytClientId(tClientId);
    if (tenant == null) {
      return "tenant does not exist";
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
    if (matchedTenants == null || matchedTenants.size() == 0) {
      return "cannot find matched tenants";
    }
    StringBuilder tenants = new StringBuilder("");
    for (int i = 0; i < matchedTenants.size(); i++) {
      tenants.append(matchedTenants.get(i).toString());
      tenants.append("\n");
    }
    return tenants.toString();
  }
}
