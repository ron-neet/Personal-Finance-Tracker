package com.ronitCodes.Personal.Finance.Tracker.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class DashboardController {

    // This method maps the root url
    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
