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
import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String start(ModelMap modelMap, HttpSession session) {
        List<Content> restrictedContentList = new ArrayList<>();

        Integer numberOfElementsToDisplay = (contentService.getAll().size() >= 5) ? 5 : contentService.getAll().size();
        if (session.getAttribute("number") != null && ((Integer)session.getAttribute("number")) >= 5) {
            numberOfElementsToDisplay = (Integer) session.getAttribute("number");
        }

        for (int i = 0; i < numberOfElementsToDisplay; i++) {
            restrictedContentList.add(contentService.getAll().get(i));
        }
        modelMap.addAttribute("contentList", restrictedContentList);
        modelMap.addAttribute("contentForm", new ContentForm());
        return "list";
    }

    @RequestMapping(value = "/more", method = RequestMethod.POST)
    public String more(ModelMap modelMap, @ModelAttribute("number") Integer number, HttpSession session) {
        int numberOfElementsToDisplay = contentService.getAll().size();

        if (number * 2 < contentService.getAll().size()) {
            numberOfElementsToDisplay = number * 2;
        }
        session.setAttribute("number", numberOfElementsToDisplay);
        modelMap.addAttribute("contentList", contentService.getAll());
        modelMap.addAttribute("contentForm", new ContentForm());

        return "redirect:/questionnaire/list";
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


    @RequestMapping(value = "/oneByOne", method = RequestMethod.GET)
    public String oneByOneGet(ModelMap modelMap) {
        modelMap.addAttribute("contentList", contentService.getAll());
        modelMap.addAttribute("contentForm", new ContentForm());
        return "oneByOne";
    }

    @RequestMapping(value = "/singleAnswer", method = RequestMethod.POST)
    public String singleAnswer(@ModelAttribute("contentForm") ContentForm contentForm,
                              BindingResult result,
                              HttpSession session) {
        if (!result.hasErrors()) {
            Content content = contentService.getById(contentForm.getId());
            content.setAnswer(contentForm.getAnswer());
            contentService.addContent(content);
            session.setAttribute("contentForm", contentForm);
        }
        return "redirect:/questionnaire/oneByOne";
    }
}