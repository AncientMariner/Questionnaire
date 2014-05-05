package org.xander.questionnaire.dao;

import org.hibernate.Criteria;
import org.xander.questionnaire.model.Content;

import java.util.List;

public class ContentHibernateDao extends AbstractHibernateDao<Content>{
    @Override
    public List<Content> getAll() {
        Criteria criteria = getSession().createCriteria(Content.class);
        return criteria.list();
    }
}
