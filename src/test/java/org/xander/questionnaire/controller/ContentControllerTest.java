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
import static org.mockito.Mockito.*;

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
    public void startTest() {
        ModelMap modelMap = mock(ModelMap.class);
        HttpSession session = mock(HttpSession.class);
        String list = contentController.start(modelMap,session);

        verify(contentService, atLeastOnce()).getAll();
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

    @Test
    public void oneByOneTest() {
        ModelMap modelMap = mock(ModelMap.class);
        String oneByOne = contentController.oneByOneGet(modelMap);

        verify(contentService, atLeastOnce()).getAll();
        verify(contentService).getById(anyLong());

        assertEquals(oneByOne, "oneByOne");
    }

    @Test
    public void oneByOneTestWithId() {
        ModelMap modelMap = mock(ModelMap.class);
        long id = 1L;
        String oneByOne = contentController.oneByOneGet(id, modelMap);

        verify(contentService, atLeastOnce()).getAll();

        assertEquals(oneByOne, "oneByOne");
    }

    @Test
    public void singleAnswerTest() {
        HttpSession session = mock(HttpSession.class);
        Content content = mock(Content.class);
        ContentForm contentForm = mock(ContentForm.class);
        BindingResult bindingResult = mock(BindingResult.class);

        when(contentService.getById(anyLong())).thenReturn(content);

        long id = 1L;
        String oneByOne = contentController.singleAnswer(contentForm, bindingResult, id, session);

        verify(contentService).getById(any(Long.class));
        verify(contentService).addContent(content);

        assertEquals(oneByOne, "redirect:/questionnaire/oneByOne/" + id);
    }
}
