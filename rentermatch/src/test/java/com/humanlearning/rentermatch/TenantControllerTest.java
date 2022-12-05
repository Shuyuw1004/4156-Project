package com.humanlearning.rentermatch;

import javax.annotation.Resource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(classes = {
    RentermatchApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

@AutoConfigureMockMvc
public class TenantControllerTest {

    private String testAuthHeader =
        "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY3MDIxNjM4MSwiaWF0IjoxNjcwMTk4MzgxfQ"
            + ".hiTDCxNeR9MjTyEbz-CIhta0jEGqZ7qzWzGjqgkPdgD_KSfz-xoHRlvZBlGdmWLk4-e6GwEaNLU1mUSzMIfEhA";

    @Resource
    private MockMvc mockMvc;

    @Test
    @DisplayName("Empty Age Tenant Insert")
    public void testMock1() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tAge cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty ClientId Tenant Insert")
    public void testMock2() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tClientId cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Constellation Tenant Insert")
    public void testMock3() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tConstellation cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Cooking Tenant Insert")
    public void testMock4() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tCooking cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty EarlyTimeSleep Tenant Insert")
    public void testMock5() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tEarlyTimeSleep cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Expenditure Tenant Insert")
    public void testMock6() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tExpenditure cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Job Tenant Insert")
    public void testMock7() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tJob cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty LateTimeSleep Tenant Insert")
    public void testMock8() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tLateTimeSleep cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty NumOfRoomates Tenant Insert")
    public void testMock9() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tNumOfRoomates cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Pet Tenant Insert")
    public void testMock10() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tPet cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Phone Tenant Insert")
    public void testMock11() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tPhone cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty PreferLocation Tenant Insert")
    public void testMock12() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tPreferLocation cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty PreferType Tenant Insert")
    public void testMock13() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tPreferType cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty PreferZipCode Tenant Insert")
    public void testMock14() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tPreferZipCode cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Smoking Tenant Insert")
    public void testMock15() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", ""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tSmoking cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("No Matching tClient Tenant Insert")
    public void testMock16() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "999")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("profile creation failed, tenant is not a client"))
                .andReturn();
    }

    @Test
    @DisplayName("Duplicate Tenant")
    public void testMock17() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/tenant/insertTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("profile creation failed, tenant already exist"))
                .andReturn();
    }

    @Test
    @DisplayName("Get Tenant with Empty tId")
    public void testMock18() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getTenantBytId")
                .header("Authorization", testAuthHeader)
                        .param("tId", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tId cannot be empty."))
                .andReturn();
    }

    @Test
    @DisplayName("Get Tenant with Wrong tId")
    public void testMock19() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getTenantBytId")
                .header("Authorization", testAuthHeader)
                        .param("tId", "9999"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tenant does not exist."))
                .andReturn();
    }

    @Test
    @DisplayName("Get Tenant By tId Successfully")
    public void testMock20() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getTenantBytId")
                .header("Authorization", testAuthHeader)
                        .param("tId", "16"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Tenant(tid=16, tAge=22, tClientId=1, tConstellation=Libra, tCooking=No, tEarlyTimeSleep=12:00, tExpenditure=1600, tGender=Male, tJob=Student, tLateTimeSleep=3:00, tMatches=null, tNumOfRoomates=3, tPet=No, tPhone=212-555-9113, tPreferLocation=New York, tPreferType=Condo, tPreferZipCode=10032, tSmoking=No)"))
                .andReturn();
    }

    @Test
    @DisplayName("Get Tenant with Empty tClientId")
    public void testMock21() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getTenantBytClientId")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tClientId cannot be empty."))
                .andReturn();
    }

    @Test
    @DisplayName("Get Tenant with Wrong tClientId")
    public void testMock22() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getTenantBytClientId")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", "9999"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tenant does not exist."))
                .andReturn();
    }

    @Test
    @DisplayName("Get Tenant By tClientId Successfully")
    public void testMock23() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getTenantBytClientId")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Tenant(tid=16, tAge=22, tClientId=1, tConstellation=Libra, tCooking=No, tEarlyTimeSleep=12:00, tExpenditure=1600, tGender=Male, tJob=Student, tLateTimeSleep=3:00, tMatches=null, tNumOfRoomates=3, tPet=No, tPhone=212-555-9113, tPreferLocation=New York, tPreferType=Condo, tPreferZipCode=10032, tSmoking=No)"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Age Tenant Update")
    public void testMock24() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tAge cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty ClientId Tenant Update")
    public void testMock25() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tClientId cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Constellation Tenant Update")
    public void testMock26() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tConstellation cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Cooking Tenant Update")
    public void testMock27() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tCooking cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty EarlyTimeSleep Tenant Update")
    public void testMock28() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tEarlyTimeSleep cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Expenditure Tenant Update")
    public void testMock29() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tExpenditure cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Job Tenant Update")
    public void testMock30() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tJob cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty LateTimeSleep Tenant Update")
    public void testMock31() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tLateTimeSleep cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty NumOfRoomates Tenant Update")
    public void testMock32() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tNumOfRoomates cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Pet Tenant Update")
    public void testMock33() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tPet cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Phone Tenant Update")
    public void testMoc34() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tPhone cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty PreferLocation Tenant Update")
    public void testMock35() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tPreferLocation cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty PreferType Tenant Update")
    public void testMock36() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tPreferType cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty PreferZipCode Tenant Update")
    public void testMock37() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tPreferZipCode cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty Smoking Tenant Update")
    public void testMock38() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "1")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tSmoking cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("No Matching tClient Tenant Update")
    public void testMock39() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .patch("/tenant/updateTenant")
                .header("Authorization", testAuthHeader)
                        .param("tAge", "22")
                        .param("tClientId", "999")
                        .param("tConstellation", "Libra")
                        .param("tCooking", "No")
                        .param("tEarlyTimeSleep", "12:00")
                        .param("tExpenditure", "1600")
                        .param("tGender", "Male")
                        .param("tJob", "Student")
                        .param("tLateTimeSleep", "3:00")
                        .param("tNumOfRoomates", "3")
                        .param("tPet", "No")
                        .param("tPhone", "212-555-9113")
                        .param("tPreferLocation", "New York")
                        .param("tPreferType", "Condo")
                        .param("tPreferZipCode", "10032")
                        .param("tSmoking", "No"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("update failed, tenant does not exist"))
                .andReturn();
    }

    @Test
    @DisplayName("Delete Tenant with Empty ClientId")
    public void testMock40() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/tenant/deleteTenant")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", ""))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tClientId cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Delete Tenant with Wrong ClientId")
    public void testMock41() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .delete("/tenant/deleteTenant")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", "9999"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("tenant does not exist"))
                .andReturn();
    }

    @Test
    @DisplayName("Empty ClientId getMatch")
    public void testMock42() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getMatch")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", ""))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tClientId cannot be empty"))
                .andReturn();
    }

    @Test
    @DisplayName("Wrong ClientId getMatch")
    public void testMock43() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getMatch")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", "abc"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().string("tenant does not exist"))
                .andReturn();
    }

    @Test
    @DisplayName("ClientId Cannot Find Match")
    public void testMock44() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getMatch")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", "3"))
                .andExpect(MockMvcResultMatchers.status().is5xxServerError())
                .andExpect(MockMvcResultMatchers.content().string("cannot find matched tenants"))
                .andReturn();
    }

    @Test
    @DisplayName("tClientId Matched With Other Tenants Successfully")
    public void testMock45() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/tenant/getMatch")
                .header("Authorization", testAuthHeader)
                        .param("tClientId", "7"))
                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Tenant(tid=19, tAge=23, tClientId=8, tConstellation=Libra, " +
//                        "tCooking=Yes, tEarlyTimeSleep=12:00, tExpenditure=3000, tGender=male, tJob=Student, tLateTimeSleep=2:00, " +
//                        "tMatches=null, tNumOfRoomates=2, tPet=Yes, tPhone=929-472-4669, tPreferLocation=New York, tPreferType=Apartment, " +
//                        "tPreferZipCode=10025, tSmoking=No)\n"))
                .andReturn();
    }

}
