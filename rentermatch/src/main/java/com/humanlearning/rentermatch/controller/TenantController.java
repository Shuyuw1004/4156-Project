package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Tenant;
import com.humanlearning.rentermatch.mapper.TenantMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("tenant")
@RestController
public class TenantController {
    @Autowired
    private TenantMapper tenantMapper;

    @GetMapping("insertStudent")
    public String insertTenant(String tid, Integer tAge, String tClientId, String tConstellation, String tCooking, String tEarlyTimeSleep, Integer tExpenditure, String tGender, String tJob, String tLateTimeSleep, Integer tNumOfRoomates, String tPet, String tPhone, String tPreferLocation, String tPreferType, String tPreferZipCode, String tSmoking) {
        if (StringUtils.isEmpty(tid)) {
            return "tid cannot be empty";
        }
        Tenant tenant = tenantMapper.selectTenant(tid);
        if (tenant != null) {
            return "profile creation failed, user already exist";
        }
        int resultCount = tenantMapper.saveTenant(tid, tAge, tClientId, tConstellation, tCooking, tEarlyTimeSleep, tExpenditure, tGender, tJob, tLateTimeSleep, tNumOfRoomates, tPet, tPhone, tPreferLocation, tPreferType, tPreferZipCode, tSmoking);
        if (resultCount == 0) return "profile creation failed";
        return "profile created successfully";
    }
}
