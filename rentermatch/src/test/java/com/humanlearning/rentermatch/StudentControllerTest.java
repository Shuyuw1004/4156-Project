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
public class StudentControllerTest {

  private final String testAuthHeader =
      "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTgyNTc3NTYyMSwiaWF0IjoxNjcwM"
          + "jU1NjIxfQ.I90zi32fdL-kFfxMRc75MHnfGWlWIgx44VQnW9fiPh9FhQkD87_r_pTPal-DMh3CK0P-Gg"
          + "WZaKeCCcj_P3ysMA";
  @Resource
  private MockMvc mockMvc;

  @Test
  @DisplayName("insertStudent Test empty email")
  void testMock1() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test empty name")
  void testMock2() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("name cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test empty sClientId")
  void testMock3() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("sClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test empty uni")
  void testMock4() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId", "testSClientId")
            .param("uni", ""))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().string("uni cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test student not client")
  void testMock5() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId", "testSClientId")
            .param("uni", "testUni"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content()
            .string("profile creation failed, student is not a client"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test student is client")
  void testMock6() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "tony@gmail.com")
            .param("name", "tony")
            .param("sClientId", "4")
            .param("uni", "tony1111"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content()
            .string("profile creation failed, student already exist"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test student is client")
  void testMock7() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "tony@gmail.com")
            .param("name", "tony")
            .param("sClientId", "4")
            .param("uni", "tony1111"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content()
            .string("profile creation failed, student already exist"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test Insert student from a client")
  void testMock8() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "test@gmail.com")
            .param("name", "testName")
            .param("sClientId", "7")
            .param("uni", "testUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("student profile created successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty email")
  void testMock9() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .string("Can't find student by this email. Invalid email."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong email")
  void testMock10() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "wrong@gmail.com"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .string("Can't find student by this email. Invalid email."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty sid")
  void testMock11() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("sid", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().string("Can't find student by this sid. Invalid sid."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong sid")
  void testMock12() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("sid", "wrongSid"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().string("Can't find student by this sid. Invalid sid."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty uni")
  void testMock13() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("uni", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().string("Can't find student by this uni. Invalid uni."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong uni")
  void testMock14() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("uni", "wrongUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(
            MockMvcResultMatchers.content().string("Can't find student by this uni. Invalid uni."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty sClientId")
  void testMock15() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("sClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .string("Can't find student by this sClientId. Invalid sClientId."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong sClientId")
  void testMock16() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("sClientId", "wrongsClientId"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .string("Can't find student by this sClientId. Invalid sClientId."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty name")
  void testMock17() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("name", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .string("Can't find student by this name. Invalid name."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong name")
  void testMock18() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("name", "wrongsName"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content()
            .string("Can't find student by this name. Invalid name."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Non-exist student")
  void testMock19() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("The student does not exist."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with email")
  void testMock20() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "test@gmail.com"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with sid")
  void testMock21() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("sid", "3"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with uni")
  void testMock22() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("uni", "testUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with sClientId")
  void testMock23() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("sClientId", "5"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=peterparker@gmail.com, name=Peter Parker, sid=2, sClientId=5, uni=pp0000)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with name")
  void testMock24() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .header("Authorization", testAuthHeader)
            .param("name", "testName"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }


  @Test
  @DisplayName("deleteStudent test empty sClientId")
  void testMock25() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/student/deleteStudent")
            .header("Authorization", testAuthHeader)
            .param("sClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("sClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteStudent test non-exist sClientId")
  void testMock26() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/student/deleteStudent")
            .header("Authorization", testAuthHeader)
            .param("sClientId", "8"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteStudent test delete test student successfully")
  void testMock27() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/student/deleteStudent")
            .header("Authorization", testAuthHeader)
            .param("sClientId", "7"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student deleted successfully"))
        .andReturn();
  }


  @Test
  @DisplayName("updateStudent test empty email")
  void testMock28() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .header("Authorization", testAuthHeader)
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test empty name")
  void testMock29() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("name cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test empty sClientId")
  void testMock30() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("sClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test empty Uni")
  void testMock31() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId", "testSClientId")
            .param("uni", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("uni cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test Non-exist student")
  void testMock32() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "mockEmail")
            .param("name", "mockName")
            .param("sClientId", "mockSClientId")
            .param("uni", "mockUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test update successfully")
  void testMock33() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .header("Authorization", testAuthHeader)
            .param("email", "tony@gmail.com")
            .param("name", "tony")
            .param("sClientId", "4")
            .param("uni", "tony1111"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student update successfully"))
        .andReturn();
  }

}
