package org.xander.questionnaire.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.xander.questionnaire.service.ContentService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@ContextConfiguration(locations = {"classpath:/org/xander/questionnaire/service/applicationContext-service.xml",
                                   "classpath:/org/xander/questionnaire/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AboutControllerTest {
    private AboutController aboutController;
    private ContentService contentService;

    @Before
    public void setUp() {
        contentService = mock(ContentService.class);
        aboutController = new AboutController(contentService);
    }

    @Test
    public void aboutPageTest() {
        String start = aboutController.about();

        assertEquals("about", start);
    }
}
