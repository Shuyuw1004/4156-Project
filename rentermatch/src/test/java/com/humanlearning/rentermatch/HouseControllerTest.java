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
class HouseControllerTest {

  private final String testAuthHeader =
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTgyNTc3NTYyMSwiaWF0IjoxNjcwM"
          + "jU1NjIxfQ.I90zi32fdL-kFfxMRc75MHnfGWlWIgx44VQnW9fiPh9FhQkD87_r_pTPal-DMh3CK0P-Gg"
          + "WZaKeCCcj_P3ysMA";

  @Resource
  private MockMvc mockMvc;

  @Test
  @DisplayName("insertHouse - empty hAddress")
  void testMock1() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "")
            .param("hPrice", "3000")
            .param("hType", "condo")
            .param("hLandlordId", "2"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("hAddress cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertHouse - empty hPrice")
  void testMock2() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "132St New York  10001")
            .param("hPrice", "")
            .param("hType", "condo")
            .param("hLandlordId", "2"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("hPrice cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertHouse - empty hType")
  void testMock3() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "131St New York  10001")
            .param("hPrice", "2000")
            .param("hType", "")
            .param("hLandlordId", "2"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("hType cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertHouse - empty landlordId")
  void testMock4() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "130St New York  10001")
            .param("hPrice", "2040")
            .param("hType", "condo")
            .param("hLandlordId", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("hLandlordId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertHouse - landlord does not exist")
  void testMock5() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "129St New York  10001")
            .param("hPrice", "2040")
            .param("hType", "condo")
            .param("hLandlordId", "999"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content()
            .string("house creation failed, landlord of the house does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("insertHouse - house already exist")
  void testMock6() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "2St NJ 10001")
            .param("hPrice", "4000")
            .param("hType", "Condo")
            .param("hLandlordId", "2"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(
            MockMvcResultMatchers.content().string("house creation failed, house already exist"))
        .andReturn();
  }

  @Test
  @DisplayName("insertHouse - successfully")
  void testMock7() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/house/insertHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "89t NY 10001")
            .param("hPrice", "2500")
            .param("hType", "House")
            .param("hLandlordId", "2"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("house created successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("updateHousePrice - hAddress empty")
  void testMock8() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/house/updateHousePrice")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "")
            .param("hPrice", "2500"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("hAddress cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateHousePrice - house does not exist")
  void testMock9() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/house/updateHousePrice")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "5 NJ 10001")
            .param("hPrice", "4000"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("house does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("updateHousePrice - update successfully")
  void testMock10() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/house/updateHousePrice")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "288 W 109th St")
            .param("hPrice", "9000"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("update successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteHouse - hAddress empty")
  void testMock11() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/house/deleteHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("hAddress cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteHouse - house does not exist")
  void testMock12() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/house/deleteHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "56st nj"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("house does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteHouse - house deleted successfully")
  void testMock13() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/house/deleteHouse")
            .header("Authorization", testAuthHeader)
            .param("hAddress", "89t NY 10001"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("house deleted successfully"))
        .andReturn();
  }
}
