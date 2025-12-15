package org.mp.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class ElementsPage {

    private SelenideElement buttonsOption = $x("//span[text()='Buttons']");

    public void clickButtonsOption() {
        buttonsOption.scrollTo().click();
    }
}