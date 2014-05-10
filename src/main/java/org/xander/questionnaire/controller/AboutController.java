package org.xander.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xander.questionnaire.service.ContentService;

@Controller
@RequestMapping("/questionnaire")
public class AboutController {
    @Qualifier("contentService")
    @Autowired
    ContentService contentService;

    public AboutController(ContentService contentService) {
        this.contentService = contentService;
    }

    protected AboutController() {
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }
}