package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Student;
import com.humanlearning.rentermatch.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("insertStudent")
    public String insertStudent(String email, String name, Integer sid, Integer sClientId, String uni) {
        if (StringUtils.isEmpty(email)) {
            return "email cannot be empty";
        }
        if (StringUtils.isEmpty(name)) {
            return "name cannot be empty";
        }
        if (StringUtils.isEmpty(sid)) {
            return "sid cannot be empty";
        }
        if (StringUtils.isEmpty(sClientId)) {
            return "sClientId cannot be empty";
        }
        if (StringUtils.isEmpty(uni)) {
            return "uni cannot be empty";
        }
        Student student = studentMapper.selectStudent(name);
        if (student != null) {
            return "profile creation failed, user already exist";
        }
        int resultCount = studentMapper.saveStudent(email, name, sid, sClientId, uni);
        if (resultCount == 0) return "profile creation failed";
        return "profile created successfully";
    }


    @GetMapping("getStudent")
    public String getStudent(String email, Integer sid, String uni, Integer sClientId, String name) {
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
}
