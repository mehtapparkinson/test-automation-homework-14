package org.mp.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ButtonsPage {

    private SelenideElement clickMeButton = $x("//button[text()='Click Me']");

    private SelenideElement dynamicClickMessage = $x("//p[@id='dynamicClickMessage']");

    public void clickClickMeButton() {
        clickMeButton.click();
    }

    public SelenideElement getDynamicClickMessage() {
        return dynamicClickMessage;
    }
}