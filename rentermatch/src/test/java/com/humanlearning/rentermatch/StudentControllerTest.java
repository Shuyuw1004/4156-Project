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
  @Resource
  private MockMvc mockMvc;

  @Test
  @DisplayName("insertStudent Test empty email")
  public void testMock1() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test empty name")
  public void testMock2() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "testEmail")
            .param("name", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("name cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test empty sClientId")
  public void testMock3() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("sClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test empty uni")
  public void testMock4() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId","testSClientId")
            .param("uni",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("uni cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test student not client")
  public void testMock5() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId","testSClientId")
            .param("uni","testUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("profile creation failed, student is not a client"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test student is client")
  public void testMock6() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "tony@gmail.com")
            .param("name", "tony")
            .param("sClientId","4")
            .param("uni","tony1111"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("profile creation failed, student already exist"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test student is client")
  public void testMock7() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "tony@gmail.com")
            .param("name", "tony")
            .param("sClientId","4")
            .param("uni","tony1111"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("profile creation failed, student already exist"))
        .andReturn();
  }

  @Test
  @DisplayName("insertStudent Test Insert student from a client")
  public void testMock8() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .post("/student/insertStudent")
            .param("email", "test@gmail.com")
            .param("name", "testName")
            .param("sClientId","7")
            .param("uni","testUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student profile created successfully"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty email")
  public void testMock9() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this email. Invalid email."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong email")
  public void testMock10() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("email", "wrong@gmail.com"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this email. Invalid email."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty sid")
  public void testMock11() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("sid",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this sid. Invalid sid."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong sid")
  public void testMock12() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("sid","wrongSid"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this sid. Invalid sid."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty uni")
  public void testMock13() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("uni",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this uni. Invalid uni."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong uni")
  public void testMock14() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("uni","wrongUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this uni. Invalid uni."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty sClientId")
  public void testMock15() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("sClientId",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this sClientId. Invalid sClientId."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong sClientId")
  public void testMock16() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("sClientId","wrongsClientId"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this sClientId. Invalid sClientId."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test empty name")
  public void testMock17() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("name",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this name. Invalid name."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test wrong name")
  public void testMock18() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("name","wrongsName"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("Can't find student by this name. Invalid name."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Non-exist student")
  public void testMock19() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("The student does not exist."))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with email")
  public void testMock20() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("email","test@gmail.com"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with sid")
  public void testMock21() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("sid","3"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with uni")
  public void testMock22() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("uni","testUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with sClientId")
  public void testMock23() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("sClientId","5"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=peterparker@gmail.com, name=Peter Parker, sid=2, sClientId=5, uni=pp0000)"))
        .andReturn();
  }

  @Test
  @DisplayName("getStudent Test Exist student with name")
  public void testMock24() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .get("/student/getStudent")
            .param("name","testName"))
        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("Student(email=test@gmail.com, name=testName, sid=3, sClientId=7, uni=testUni)"))
        .andReturn();
  }


  @Test
  @DisplayName("deleteStudent test empty sClientId")
  public void testMock25() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/student/deleteStudent")
            .param("sClientId", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("sClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteStudent test non-exist sClientId")
  public void testMock26() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/student/deleteStudent")
            .param("sClientId", "8"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student does not exist"))
        .andReturn();
  }

  @Test
  @DisplayName("deleteStudent test delete test student successfully")
  public void testMock27() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .delete("/student/deleteStudent")
            .param("sClientId", "7"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student deleted successfully"))
        .andReturn();
  }


  @Test
  @DisplayName("updateStudent test empty email")
  public void testMock28() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .param("email", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("email cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test empty name")
  public void testMock29() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .param("email", "testEmail")
            .param("name", ""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("name cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test empty sClientId")
  public void testMock30() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("sClientId cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test empty Uni")
  public void testMock31() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .param("email", "testEmail")
            .param("name", "testName")
            .param("sClientId","testSClientId")
            .param("uni",""))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("uni cannot be empty"))
        .andReturn();
  }

  @Test
  @DisplayName("updateStudent test Non-exist student")
  public void testMock32() throws Exception {
    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
            .patch("/student/updateStudent")
            .param("email", "mockEmail")
            .param("name", "mockName")
            .param("sClientId","mockSClientId")
            .param("uni","mockUni"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("student does not exist"))
        .andReturn();
  }
//
//  @Test
//  @DisplayName("updateStudent test update successfully")
//  public void testMock33() throws Exception {
//    MvcResult result = mockMvc.perform(MockMvcRequestBuilders
//            .patch("/student/updateStudent")
//            .param("email", "tony@gmail.com")
//            .param("name", "ton7")
//            .param("sClientId","4")
//            .param("uni","tony1111"))
//        .andExpect(MockMvcResultMatchers.status().isOk())
//        .andExpect(MockMvcResultMatchers.content().string("student update successfully"))
//        .andReturn();
//  }

}
