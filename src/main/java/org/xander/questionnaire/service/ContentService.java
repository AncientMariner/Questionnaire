package org.xander.questionnaire.service;

import org.xander.questionnaire.model.Content;

import java.util.List;

public interface ContentService {
    Content getById(Long id);
    void addContent(Content content);
    List<Content> getAll();
}
