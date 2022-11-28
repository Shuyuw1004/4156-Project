package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Student;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import com.humanlearning.rentermatch.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClientMapper clientMapper;

    @PostMapping("insertStudent")
    public String insertStudent(String email, String name, String sClientId, String uni) {
        if (email == null) {
            return "email cannot be empty";
        }
        if (name == null) {
            return "name cannot be empty";
        }
        if (sClientId == null) {
            return "sClientId cannot be empty";
        }
        if (uni == null) {
            return "uni cannot be empty";
        }
        // check if sClientId in client database
        Client client = clientMapper.selectClientBycId(sClientId);
        if (client == null) {
            return "profile creation failed, student is not a client";
        }
        Student student = studentMapper.selectStudent(name);
        if (student != null) {
            return "profile creation failed, student already exist";
        }
        int resultCount = studentMapper.saveStudent(email, name, sClientId, uni);
        if (resultCount == 0) return "studnet profile creation failed";
        return "student profile created successfully";
    }


    @GetMapping("getStudent")
    public String getStudent(String email, String sid, String uni, String sClientId, String name) {
        Student student;
        if (email != null) {
            student = studentMapper.selectStudentByemail(email);
            if (student != null) {
                return student.toString();
            } else
                return "Can't find student by this email. Invalid email.";
        } else if (sid != null) {
            student = studentMapper.selectStudentBysid(sid);
            if (student != null) {
                return student.toString();
            } else
                return "Can't find student by this sid. Invalid sid.";
        } else if (uni != null) {
            student = studentMapper.selectStudentByuni(uni);
            if (student != null) {
                return student.toString();
            } else
                return "Can't find student by this uni. Invalid uni.";
        } else if (sClientId != null) {
            student = studentMapper.selectStudentBysClientId(sClientId);
            if (student != null) {
                return student.toString();
            } else
                return "Can't find student by this sClientId. Invalid sClientId.";
        } else if (name != null) {
            student = studentMapper.selectStudentByname(name);
            if (student != null) {
                return student.toString();
            } else
                return "Can't find student by this name. Invalid name.";
        } else return "The student does not exist.";
    }

    @DeleteMapping("deleteStudent")
    public String deleteStudent(String sClientId) {
        Student student = studentMapper.selectStudentBysClientId(sClientId);
        if (student == null) {
            return "student does not exist";
        }
        int resultCount = studentMapper.deleteStudentBysClientId(sClientId);
        if (resultCount == 0) {
            return "delete failed";
        }
        else
            return "student deleted successfully";
    }

    @PatchMapping("updateStudent")
    public String updateStudent(String email, String name, String sClientId, String uni) {
        if (email == null) {
            return "email cannot be empty";
        }
        if (name == null) {
            return "name cannot be empty";
        }
        if (sClientId == null) {
            return "sClientId cannot be empty";
        }
        if (uni == null) {
            return "uni cannot be empty";
        }
        Student student = studentMapper.selectStudentBysClientId(sClientId);
        if (student == null) {
            return "student does not exist";
        }
        int resultCount = studentMapper.updateStudent(sClientId, email, name, uni);
        if(resultCount == 0) {
            return "update failed";
        }
        else
            return "student update successfully";
    }
}
