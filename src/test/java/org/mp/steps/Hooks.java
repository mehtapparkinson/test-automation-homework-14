package org.mp.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 30000;
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}