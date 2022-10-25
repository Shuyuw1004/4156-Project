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
    return "profile created successfully";
  }
}
