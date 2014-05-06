package org.xander.questionnaire.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.xander.questionnaire.forms.ContentForm;
import org.xander.questionnaire.model.Content;
import org.xander.questionnaire.service.ContentService;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ContextConfiguration(locations = {"classpath:/org/xander/questionnaire/service/applicationContext-service.xml",
                                   "classpath:/org/xander/questionnaire/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ContentControllerTest {
    private ContentController contentController;
    private ContentService contentService;

    @Before
    public void setUp() {
        contentService = mock(ContentService.class);
        contentController = new ContentController(contentService);
    }

    @Test
    public void initPageTest() {
        String init = contentController.init();

        assertEquals("init", init);
    }

    @Test
    public void aboutPageTest() {
        String start = contentController.about();

        assertEquals("about", start);
    }

    @Test
    public void startTest() {
        ModelMap modelMap = mock(ModelMap.class);
        String list = contentController.start(modelMap);
        verify(contentService).getAll();
        assertEquals("list", list);
    }

    @Test
    public void newGetTest() {
        ModelMap modelMap = mock(ModelMap.class);
        String list = contentController.newGetItem(modelMap);
        verify(contentService).addContent(any(Content.class));
        assertEquals("redirect:/questionnaire/list", list);
    }

    @Test
    public void newPostTest() {
        ModelMap modelMap = mock(ModelMap.class);
        ContentForm contentForm = mock(ContentForm.class);
        BindingResult bindingResult = mock(BindingResult.class);
        HttpSession session = mock(HttpSession.class);

        String list = contentController.newPostItem(contentForm, bindingResult, session);

        verify(contentService).addContent(any(Content.class));

        assertEquals("redirect:/questionnaire/list", list);
    }
}
