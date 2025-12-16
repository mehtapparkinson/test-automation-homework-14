package org.mp.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.mp.pages.ButtonsPage;
import org.mp.pages.ElementsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class ClickButtonSteps {

    private ElementsPage elementsPage = new ElementsPage();
    private ButtonsPage buttonsPage = new ButtonsPage();

    @Given("I am on the elements page")
    public void i_am_on_the_elements_page() {
        open("https://demoqa.com/elements");
        sleep(1000);
    }

    @When("I click on Buttons option")
    public void i_click_on_buttons_option() {
        elementsPage.clickButtonsOption();
        sleep(1000);
    }

    @When("I click on Click Me button")
    public void i_click_on_click_me_button() {
        buttonsPage.clickClickMeButton();
        sleep(500);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        buttonsPage.getDynamicClickMessage()
                .shouldBe(visible)
                .shouldHave(text(expectedMessage));
    }
}