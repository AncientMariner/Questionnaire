package org.xander.questionnaire.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xander.questionnaire.dao.Dao;
import org.xander.questionnaire.model.Content;

@Service(value = "contentService")
@Transactional
public class TransactionalContentService implements ContentService {
    Dao dao;
    public TransactionalContentService(Dao dao) {
        this.dao = dao;
    }
    @Override
    public Content getById(Long id) {
        return (Content) dao.get(id);
    }

    @Override
    public void addContent(Content content) {
        dao.saveOrUpdate(content);
    }
}
