package org.xander.questionnaire.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.xander.questionnaire.dao.Dao;
import org.xander.questionnaire.model.Content;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@ContextConfiguration(locations = {"classpath:/org/xander/questionnaire/service/applicationContext-service.xml",
                                   "classpath:/org/xander/questionnaire/model/applicationContext-dao.xml"})
public class ContentServiceTest {
    @Mock
    private Dao dao;
    private ContentService contentService;

    @Before
    public void setUp() {
        initMocks(this);
        contentService = new TransactionalContentService(dao);
    }

    @Test
    public void getByIdTest() {
        Content content = mock(Content.class);

        when(dao.get(content.getId())).thenReturn(content);

        contentService.getById(content.getId());

        verify(dao).get(anyLong());
    }

    @Test
    public void createContentTest(){
        Content content = mock(Content.class);

        contentService.addContent(content);

        verify(dao).saveOrUpdate(any(Content.class));
    }

    @Test
    public void getAllTest() {
        Content content = mock(Content.class);

        contentService.getAll();
        verify(dao).getAll();
    }
}
