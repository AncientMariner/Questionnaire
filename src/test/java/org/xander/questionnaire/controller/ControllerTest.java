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

@ContextConfiguration(locations = {"classpath:/org/xander/questionnaire/service/applicationContext-service.xml",
                                   "classpath:/org/xander/questionnaire/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ControllerTest {
    private ContentController contentController;
    private ContentService contentService;

    @Before
    public void setUp() {
        contentService = mock(ContentService.class);
        contentController = new ContentController(contentService);
    }

    @Test
    public void startPageTest() {
        ModelMap modelMap = mock(ModelMap.class);

        String start = contentController.start(modelMap);

        assertEquals("start", start);

    }
}
