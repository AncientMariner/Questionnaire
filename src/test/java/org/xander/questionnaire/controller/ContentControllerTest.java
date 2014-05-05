package org.xander.questionnaire.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.xander.questionnaire.service.ContentService;

import static org.junit.Assert.assertEquals;
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
        ModelMap modelMap = mock(ModelMap.class);

        String init = contentController.init(modelMap);

        assertEquals("init", init);
    }

    @Test
    public void aboutPageTest() {
        ModelMap modelMap = mock(ModelMap.class);

        String start = contentController.about(modelMap);

        assertEquals("about", start);
    }

    @Test
    public void startTest() {
        ModelMap modelMap = mock(ModelMap.class);
        String start = contentController.start(modelMap);
        verify(contentService).getAll();
        assertEquals("start", start);
    }
}
