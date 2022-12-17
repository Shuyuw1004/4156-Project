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
class ClientControllerTest {

  @Resource
  private MockMvc mockMvc;

  @Test
  @DisplayName("Empty Email Login")
  public void testMock1() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/login")
            .param("email", "")
            .param("password", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty Password Login")
  public void testMock2() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/login")
            .param("email", "kevinceltics09@hotmail.com")
            .param("password", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("password cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("Wrong Password Login")
  public void testMock3() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/login")
            .param("email", "kevinceltics09@hotmail.com")
            .param("password", "1234"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("wrong password"))
        .andReturn();
  }

  @Test
  @DisplayName("Client Not Exist Login")
  public void testMock4() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .post("/client/login")
                    .param("email", "null@hotmail.com")
                    .param("password", "1234"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content().string("no email associated"))
            .andReturn();
  }

  @Test
  @DisplayName("Correct Password Login")
  public void testMock5() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/login")
            .param("email", "wl2828@columbia.edu")
            .param("password", "Aa12345678"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("login successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty Email Register")
  public void testMock6() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/register")
            .param("name", "Lena Smith")
            .param("password", "123")
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("register fail, email cannot be empty!"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty Password Register")
  public void testMock7() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/register")
            .param("name", "Lena Smith")
            .param("password", "")
            .param("email", "kevinceltics09@hotmail.com"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("register fail, password cannot be empty!"))
        .andReturn();
  }

  @Test
  @DisplayName("Empty Name Register")
  public void testMock8() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/register")
            .param("name", "")
            .param("password", "123")
            .param("email", "kevinceltics09@hotmail.com"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("register fail, password must contain minimum eight characters, at least one letter and one number!"))
        .andReturn();
  }

  @Test
  @DisplayName("Duplicate User Register")
  public void testMock9() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/client/register")
            .param("name", "Lena Smith")
            .param("password", "123")
            .param("email", "kevinceltics09@hotmail.com"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("register fail, password must contain minimum eight characters, at least one letter and one number!"))
        .andReturn();
  }

  @Test
  @DisplayName("Client Successfully Register")
  public void testMock10() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .post("/client/register")
                    .param("name", "123")
                    .param("password", "Aa12345678")
                    .param("email", "wl2829@columbia.edu"))
//            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.)//string("^[0-9]{1, 100}$)"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
  }

  @Test
  @DisplayName("Client Not Exist getClientByEmail")
  public void testMock11() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getClientByEmail")
                    .param("email", "johnwhite@hotmail.com"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("The client does not exist."))
            .andReturn();
  }

  @Test
  @DisplayName("Email Empty getClientByEmail")
  public void testMock12() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getClientByEmail")
                    .param("email", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("Email cannot be empty."))
            .andReturn();
  }

  @Test
  @DisplayName("Client Not Exist getClientBycId")
  public void testMock13() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getClientBycId")
                    .param("cid", "50"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("The client does not exist."))
            .andReturn();
  }

  @Test
  @DisplayName("cId Empty getClientBycId")
  public void testMock14() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getClientBycId")
                    .param("cid", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("cId cannot be empty."))
            .andReturn();
  }

  @Test
  @DisplayName("Password Empty deleteClient")
  public void testMock15() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .delete("/client/deleteClient")
                    .param("name", "John Smith")
                    .param("password", "")
                    .param("email", "johnsmith@hotmail.com"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("password cannot be empty"))
            .andReturn();
  }

  @Test
  @DisplayName("Name Empty deleteClient")
  public void testMock16() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .delete("/client/deleteClient")
                    .param("name", "")
                    .param("password", "123")
                    .param("email", "johnsmith@hotmail.com"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("name cannot be empty"))
            .andReturn();
  }

  @Test
  @DisplayName("Email Empty deleteClient")
  public void testMock17() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .delete("/client/deleteClient")
                    .param("name", "John Smith")
                    .param("password", "123")
                    .param("email", ""))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
            .andReturn();
  }

  @Test
  @DisplayName("Client Not Exist deleteClient")
  public void testMock18() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .delete("/client/deleteClient")
                    .param("name", "John Smith")
                    .param("password", "123")
                    .param("email", "johnwhite@hotmail.com"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("client doest not exist"))
            .andReturn();
  }

  @Test
  @DisplayName("Client Delete Successfully deleteClient")
  public void testMock19() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .delete("/client/deleteClient")
                    .param("name", "123")
                    .param("password", "Aa12345678")
                    .param("email", "wl2829@columbia.edu"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("client deleted successfully"))
            .andReturn();
  }

  @Test
  @DisplayName("Tenant Not Exist getTenantByZipcode")
  void testMock20() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getTenantByZipcode")
                    .header("Authorization")
                    .param("zipcode", "null"))
            .andExpect(MockMvcResultMatchers.status().is5xxServerError())
            .andExpect(MockMvcResultMatchers.content().string("The tenant does not exist."))
            .andReturn();
  }
  @Test
  @DisplayName("Zipcode Empty getTenantByZipcode")
  void testMock21() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getTenantByZipcode")
                    .header("Authorization")
                    .param("zipcode", ""))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content().string("Zipcode cannot be empty."))
            .andReturn();
  }

  @Test
  @DisplayName("Successful getZipcode")
  void testMock22() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                    .get("/client/getZipcode")
                    .header("Authorization"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("10025"))
            .andReturn();
  }
}
