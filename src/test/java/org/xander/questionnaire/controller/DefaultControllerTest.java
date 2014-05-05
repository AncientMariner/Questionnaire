package org.xander.questionnaire.controller;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DefaultControllerTest {
    private DefaultController defaultController;

    @Before
    public void setUp() {
        defaultController = new DefaultController();
    }

    @Test
    public void defaultControllerTest() {
        String homepage = "redirect:/questionnaire/init";
        String actual = defaultController.homePage();

        assertEquals(homepage, actual);
    }
}
