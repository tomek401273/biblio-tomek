package com.tgrajkowski.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "refresh/")
public class RefreshController {

    @RequestMapping(method = RequestMethod.GET, value = "now")
    public String refreshBackend() {
        return "refreshed successfully!!!";
    }
}
