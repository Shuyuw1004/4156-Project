package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Student;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.StudentMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("student")
@RestController
public class StudentController {

  @Autowired
  private StudentMapper studentMapper;
  @Autowired
  private ClientMapper clientMapper;
  private final static Logger LOGGER =
          Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
  final static String emptyCid= "sClientId cannot be empty";

  @PostMapping("insertStudent")
  public ResponseEntity<String> insertStudent(String email, String name, String sClientId,
      String uni) {
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("Access-Control-Allow-Origin", "*");
    responseHeaders.set("Access-Control-Allow-Headers",
        "X-API-KEY, Origin, X-Requested-With, Content-Type, Accept, Access-Control-Request-Method, Authorization");
    responseHeaders.set("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE, PATCH");
    if (email == null || email.isEmpty()) {
      return new ResponseEntity<>("email cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    if (name == null || name.isEmpty()) {
      return new ResponseEntity<>("name cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    if (sClientId == null || sClientId.isEmpty()) {
      return new ResponseEntity<>(emptyCid, responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    if (uni == null || uni.isEmpty()) {
      return new ResponseEntity<>("uni cannot be empty", responseHeaders, HttpStatus.BAD_REQUEST);
    }
    // check if sClientId in client database
    Client client = clientMapper.selectClientBycId(sClientId);
    if (client == null) {
      return new ResponseEntity<>("profile creation failed, student is not a client",
          responseHeaders, HttpStatus.BAD_REQUEST);
    }
    Student student = studentMapper.selectStudent(name);
    if (student != null) {
      return new ResponseEntity<>("profile creation failed, student already exist", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    int resultCount = studentMapper.saveStudent(email, name, sClientId, uni);
    if (resultCount == 0) {
      return new ResponseEntity<>("studnet profile creation failed", responseHeaders,
          HttpStatus.BAD_REQUEST);
    }
    StudentController.LOGGER.log(Level.INFO, "reach here");
    return new ResponseEntity<>("student profile created successfully", responseHeaders,
        HttpStatus.OK);
  }


  @GetMapping("getStudent")
  public String getStudent(String email, String sid, String uni, String sClientId, String name) {
    Student student;
    if (email != null) {
      student = studentMapper.selectStudentByemail(email);
      if (student != null) {
        return student.toString();
      } else {
        return "Can't find student by this email. Invalid email.";
      }
    } else if (sid != null) {
      student = studentMapper.selectStudentBysid(sid);
      if (student != null) {
        return student.toString();
      } else {
        return "Can't find student by this sid. Invalid sid.";
      }
    } else if (uni != null) {
      student = studentMapper.selectStudentByuni(uni);
      if (student != null) {
        return student.toString();
      } else {
        return "Can't find student by this uni. Invalid uni.";
      }
    } else if (sClientId != null) {
      student = studentMapper.selectStudentBysClientId(sClientId);
      if (student != null) {
        return student.toString();
      } else {
        return "Can't find student by this sClientId. Invalid sClientId.";
      }
    } else if (name != null) {
      student = studentMapper.selectStudentByname(name);
      if (student != null) {
        return student.toString();
      } else {
        return "Can't find student by this name. Invalid name.";
      }
    } else {
      return "The student does not exist.";
    }
  }

  @DeleteMapping("deleteStudent")
  public String deleteStudent(String sClientId) {
    //Check whether sClientId is empty
    if (sClientId == null || sClientId.isEmpty()) {
      return emptyCid;
    }
    Student student = studentMapper.selectStudentBysClientId(sClientId);
    if (student == null) {
      return "student does not exist";
    }
    int resultCount = studentMapper.deleteStudentBysClientId(sClientId);
    if (resultCount == 0) {
      return "delete failed";
    } else {
      return "student deleted successfully";
    }
  }

  @PatchMapping("updateStudent")
  public String updateStudent(String email, String name, String sClientId, String uni) {
    if (email == null || email.isEmpty()) {
      return "email cannot be empty";
    }
    if (name == null || name.isEmpty()) {
      return "name cannot be empty";
    }
    if (sClientId == null || sClientId.isEmpty()) {
      return emptyCid;
    }
    if (uni == null || uni.isEmpty()) {
      return "uni cannot be empty";
    }
    Student student = studentMapper.selectStudentBysClientId(sClientId);
    if (student == null) {
      return "student does not exist";
    }
    int resultCount = studentMapper.updateStudent(sClientId, email, name, uni);
    if (resultCount == 0) {
      return "update failed";
    } else {
      return "student update successfully";
    }
  }
}
