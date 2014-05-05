package org.xander.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xander.questionnaire.service.ContentService;

@Controller
@RequestMapping("/questionnaire")
public class ContentController {

    @Qualifier("contentService")
    @Autowired
    ContentService contentService;

    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    protected ContentController() {
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String init(ModelMap model) {
        return "init";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(ModelMap model) {
        return "about";
    }


    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start(ModelMap modelMap) {
//        contentService.addContent(new Content());
        modelMap.addAttribute("contentList", contentService.getAll());
        return "start";
    }
//    TODO add new question/answer option
//    TODO save answer
//    TODO display list
}
