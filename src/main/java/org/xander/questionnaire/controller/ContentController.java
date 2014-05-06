package org.xander.questionnaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xander.questionnaire.forms.ContentForm;
import org.xander.questionnaire.model.Content;
import org.xander.questionnaire.service.ContentService;

import javax.servlet.http.HttpSession;

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
    public String init() {
        return "init";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "about";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String start(ModelMap modelMap) {
        modelMap.addAttribute("contentList", contentService.getAll());
        modelMap.addAttribute("contentForm", new ContentForm());
        return "list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newGetItem(ModelMap modelMap) {
        contentService.addContent(new Content());
        modelMap.addAttribute("contentList", contentService.getAll());
        return "redirect:/questionnaire/list";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String newPostItem(@ModelAttribute("contentForm") ContentForm contentForm,
                              BindingResult result,
                              HttpSession session) {
        if (!result.hasErrors()) {
            Content content = new Content();
            content.setQuestion(contentForm.getQuestion());
            content.setAnswer(contentForm.getAnswer());
            contentService.addContent(content);
            session.setAttribute("contentForm", contentForm);
        }
        return "redirect:/questionnaire/list";
    }
}
