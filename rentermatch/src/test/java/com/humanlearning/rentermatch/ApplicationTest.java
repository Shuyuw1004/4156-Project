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
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTY3MDExNzk5OCwiaWF0IjoxNjcwMDk5OTk4fQ"
          + ".c216RdkCyNh1webpyKY8NoBIQ8jlxq6XGq-ba8gHF-chbuP-un6w9GFtmd6lQtQeGAhye_tDMPhHJhBNtkkeFA";

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
