package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
import com.humanlearning.rentermatch.domain.Tenant;
import com.humanlearning.rentermatch.mapper.ClientMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("client")
@RestController
public class ClientController {

    @Autowired
    private ClientMapper clientMapper;

    @GetMapping("login")
    public String login(String email, String password) {
        //Check whether email is empty
        if (StringUtils.isEmpty(email)) {
            return "email cannot be empty";
        }
        //Check whether password is empty
        if (StringUtils.isEmpty(password)) {
            return "password cannot be empty";
        }
        //Select client from database by email
        Client client = clientMapper.selectClient(email);
        //If client does not exist
        if (client == null) {
            return "login failed";
        }
        //Check whether the password matches the one stored in database
        if (password.equals(client.getPassword())) {
            return "login successfully";
        }
        return "wrong password";
    }


    @GetMapping("register")
    public String register(String password, String name, String email) {

        //Check whether email is empty
        if (StringUtils.isEmpty(email)) {
            return "email cannot be empty";
        }
        //Check whether password is empty
        if (StringUtils.isEmpty(password)) {
            return "password cannot be empty";
        }
        //Check whether name is empty
        if (StringUtils.isEmpty(name)) {
            return "name cannot be empty";
        }
        //Select client from database by email
        Client client = clientMapper.selectClient(email);
        //Check whether client already exist
        if (client != null) {
            return "register failed, user already exist";
        }
        //Return 1 if saved successfully; return 0 if failed
        int resultCount = clientMapper.saveClient(password, name, email);
        if (resultCount == 0) {
            return "register failed";
        }
        return "register successfully";
    }


    @GetMapping("getClientByEmail")
    public String getClientByEmail(String email) {
        if (email != null) {
            Client client = clientMapper.selectClientByEmail(email);
            if (client != null) {
                return client.toString();
            } else
                return "The client does not exist.";
        } else
            return "Email cannot be empty.";
    }

    @GetMapping("getClientBycId")
    public String getClientBycId(Integer cid) {
        if (cid != null) {
            Client client = clientMapper.selectClientBycId(cid);
            if (client != null) {
                return client.toString();
            } else
                return "The client does not exist.";
        } else
            return "cId cannot be empty.";
    }
}
