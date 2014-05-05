package org.xander.questionnaire.dao;

import org.xander.questionnaire.model.Persistent;

import java.util.List;

public interface Dao<T extends Persistent> {
    void saveOrUpdate(T content);
    T get(Long id);
    List<T> getAll();
}
