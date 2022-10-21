package com.humanlearning.rentermatch.controller;

import com.humanlearning.rentermatch.domain.Client;
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
    public String login(String name, String password) {
        if (StringUtils.isEmpty(name)) {
            return "name cannot be empty";
        }
        if (StringUtils.isEmpty(password)) {
            return "password cannot be empty";
        }
        Client client = clientMapper.selectClient(name);
        if (client == null) {
            return "login failed";
        }
        if (password.equals(client.getPassword())) {
            return "login successfully";
        }
        return "wrong password";
    }

    @GetMapping("register")
    public String register(String name, String password) {
        if (StringUtils.isEmpty(name)) {
            return "name cannot be empty";
        }
        if (StringUtils.isEmpty(password)) {
            return "password cannot be empty";
        }
        Client client = clientMapper.selectClient(name);
        if (client != null) {
            return "register failed, user already exist";
        }
        int resultCount = clientMapper.saveClient(name, password);
        if (resultCount == 0) return "register failed";
        return "register successfully";
    }
}
