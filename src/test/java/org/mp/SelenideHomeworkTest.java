package org.mp;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mp.pages.ButtonsPage;
import org.mp.pages.ElementsPage;
import org.mp.pages.WebTablesPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SelenideHomeworkTest {

    private ElementsPage elementsPage;
    private ButtonsPage buttonsPage;
    private WebTablesPage webTablesPage;

    @Before
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.headless = false;
        Configuration.pageLoadTimeout = 30000;

        elementsPage = new ElementsPage();
        buttonsPage = new ButtonsPage();
        webTablesPage = new WebTablesPage();
    }

    @Test
    public void test1_ClickButton() {
        open("https://demoqa.com/elements");
        sleep(1000); //

        elementsPage.clickButtonsOption();
        sleep(1000);

        buttonsPage.clickClickMeButton();
        sleep(500);

        buttonsPage.getDynamicClickMessage()
                .shouldBe(visible)
                .shouldHave(text("You have done a dynamic click"));
    }

    @Test
    public void test2_AddRecord() {
        open("https://demoqa.com/webtables");
        sleep(1000);

        webTablesPage.clickAddButton();
        sleep(500);

        webTablesPage.fillForm("Mehtap", "Parkinson", "mehtap@parkinson.com",
                "31", "1000", "Engineering");
        sleep(500);

        webTablesPage.clickSubmit();
        sleep(1000);

        webTablesPage.getRecordByFirstName("Mehtap")
                .shouldBe(visible);
    }

    @Test
    public void test3_EditRecord() {
        open("https://demoqa.com/webtables");
        sleep(1000);

        webTablesPage.clickAddButton();
        sleep(500);

        webTablesPage.fillForm("Mehtap", "Parkinson", "mehtap@parkinson.com",
                "31", "1000", "Engineering");
        sleep(500);

        webTablesPage.clickSubmit();
        sleep(1000);

        webTablesPage.clickEditButton("Mehtap");
        sleep(500);

        webTablesPage.clearAndUpdateDepartment("QA");
        sleep(500);

        webTablesPage.clickSubmit();
        sleep(1000);

        webTablesPage.getDepartmentCell("QA")
                .shouldBe(visible);
    }

    @After
    public void tearDown() {
        sleep(1000);
        Selenide.closeWebDriver();
    }
}