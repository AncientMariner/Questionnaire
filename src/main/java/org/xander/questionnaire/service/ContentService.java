package org.xander.questionnaire.service;

import org.xander.questionnaire.model.Content;

public interface ContentService {
    Content getById(Long id);
    void addContent(Content content);
}
