package org.xander.questionnaire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
    @RequestMapping(value = "/")
    public String homePage() {
        return "redirect:/questionnaire/init";
    }
}
