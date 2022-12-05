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
class LandlordControllerTest {

  private final String testAuthHeader =
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTgyNTc3NTYyMSwiaWF0IjoxNjcwM"
          + "jU1NjIxfQ.I90zi32fdL-kFfxMRc75MHnfGWlWIgx44VQnW9fiPh9FhQkD87_r_pTPal-DMh3CK0P-Gg"
          + "WZaKeCCcj_P3ysMA";

  @Resource
  private MockMvc mockMvc;

  @Test
  @DisplayName("Empty lPhone insertLandlord")
  void testMock1() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/landlord/insertLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "")
            .param("lClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("lPhone cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty lClientId insertLandlord")
  void testMock2() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/landlord/insertLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "917-555-4533")
            .param("lClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("lClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Not Client insertLandlord")
  void testMock3() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/landlord/insertLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "917-555-4533")
            .param("lClientId", "50"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content()
            .string("landlord creation failed, landlord is not a client"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Exist insertLandlord")
  void testMock4() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/landlord/insertLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "917-555-4533")
            .param("lClientId", "7"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content()
            .string("landlord creation failed, landlord already exist"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Created Successfully")
  void testMock5() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/landlord/insertLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "311-789-1212")
            .param("lClientId", "4"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("landlord created successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty lPhone updateLandlord")
  void testMock6() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/landlord/updateLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "")
            .param("lClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("lPhone cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty lClientId updateLandlord")
  void testMock7() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/landlord/updateLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "311-789-1212")
            .param("lClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("lClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Not Exist updateLandlord")
  void testMock8() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/landlord/updateLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "311-789-1212")
            .param("lClientId", "50"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("landlord does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Update Successfully updateLandlord")
  void testMock9() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/landlord/updateLandlord")
            .header("Authorization", testAuthHeader)
            .param("lPhone", "311-789-1212")
            .param("lClientId", "2"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("update successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty lClientId deleteLandlord")
  void testMock10() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/landlord/deleteLandlord")
            .header("Authorization", testAuthHeader)
            .param("lClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("lClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Not Exist deleteLandlord")
  void testMock11() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/landlord/deleteLandlord")
            .header("Authorization", testAuthHeader)
            .param("lClientId", "50"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("landlord does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("Landlord Delete Successfully deleteLandlord")
  void testMock12() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/landlord/deleteLandlord")
            .header("Authorization", testAuthHeader)
            .param("lClientId", "4"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("delete successfully"))
        .andReturn();
  }
}
