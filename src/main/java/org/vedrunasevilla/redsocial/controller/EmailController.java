package org.vedrunasevilla.redsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vedrunasevilla.redsocial.services.EmailServiceI;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailServiceI emailService;


}
