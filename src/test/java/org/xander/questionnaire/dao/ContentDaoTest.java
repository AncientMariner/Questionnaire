package org.xander.questionnaire.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.xander.questionnaire.model.Content;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath:/org/xander/questionnaire/model/applicationContext-dao.xml"})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ContentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private Dao dao;

    @Test
    public void getTest() {
        Content content = new Content();
        dao.saveOrUpdate(content);

        Content result = (Content) dao.get(content.getId());
        assertEquals(content.getId(), result.getId());
    }
}
