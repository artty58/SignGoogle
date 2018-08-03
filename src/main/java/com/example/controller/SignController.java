package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.server.ui.LogoutPageGeneratingWebFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestMapping("/sign")
@Controller
public class SignController {
    protected static Logger LOGGER = LoggerFactory.getLogger(SignController.class);

    @Autowired
    SignService signService;

    @PostMapping("/savesign")
    public ResponseEntity<String> save(@RequestBody String json) {
        return signService.save(json);

    }
    @GetMapping("/findByUser")
    public ResponseEntity<String> findByUser(@RequestParam String email) {

//        LOGGER.info("Hello");
        return signService.findByUser(email);
    }
}
