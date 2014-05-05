package org.xander.questionnaire;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContentTest {
    @Test
    public void defaultTest() {
        Content content = new Content();
        assertTrue(content.exists());
        assertEquals("default question", content.getQuestion());
        assertEquals("default answer", content.getAnswer());
    }

    @Test
    public void defaultTestForSetter() {
        String question = "my question";
        String answer = "my answer";

        Content content = new Content();
        content.setQuestion(question);
        content.setAnswer(answer);

        assertEquals(question, content.getQuestion());
        assertEquals(answer, content.getAnswer());
    }
}
