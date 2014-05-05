package org.xander.questionnaire.dao;

import org.xander.questionnaire.model.Persistent;

public interface Dao<T extends Persistent> {
    void saveOrUpdate(T content);
    T get(Long id);
}
