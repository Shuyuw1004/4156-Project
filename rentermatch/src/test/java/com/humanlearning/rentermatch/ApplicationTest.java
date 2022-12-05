package com.humanlearning.rentermatch;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = {
    RentermatchApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApplicationTest {

  private String testAuthHeader =
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY3MDI3MjgzNCwiaWF0IjoxNjcwMjU0ODM0fQ."
          + "9_g8ljjeCl_vryHTDf_ifW7Ur6g34wMeQ1LtFUv39EY8cAW_pav0mTR0qRRGf3KnrOvNwMMBwffJlisKEPCA-w";

  @Resource
  private MockMvc mockMvc;

  @Before
  public void setup() {
    this.mockMvc = MockMvcBuilders.standaloneSetup(new RentermatchApplication()).build();
  }


  @Test
  @DisplayName("Main Page Test")
  public void testHomePage() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/")
            .header("Authorization", testAuthHeader))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.view().name("forward:index.html"))
        .andReturn();
  }


}
