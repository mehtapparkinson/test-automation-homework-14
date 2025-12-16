package org.mp.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;
import org.mp.pages.WebTablesPage;

import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class AddRecordSteps {

    private WebTablesPage webTablesPage = new WebTablesPage();

    @Given("I am on the web tables page")
    public void i_am_on_the_web_tables_page() {
        open("https://demoqa.com/webtables");
        sleep(1000);
    }

    @When("I click on Add button")
    public void i_click_on_add_button() {
        webTablesPage.clickAddButton();
        sleep(500);
    }

    @When("I fill the form with following data")
    public void i_fill_the_form_with_following_data(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        webTablesPage.fillForm(
                data.get("firstName"),
                data.get("lastName"),
                data.get("email"),
                data.get("age"),
                data.get("salary"),
                data.get("department")
        );
        sleep(500);
    }

    @When("I click on Submit button")
    public void i_click_on_submit_button() {
        webTablesPage.clickSubmit();
        sleep(1000);
    }

    @Then("I should see the record with first name {string}")
    public void i_should_see_the_record_with_first_name(String firstName) {
        webTablesPage.getRecordByFirstName(firstName).shouldBe(visible);
    }

    @And("I click on Edit button for {string}")
    public void i_click_on_edit_button_for(String firstName) {
        // Edit butonuna scroll yap
        webTablesPage.getRecordByFirstName(firstName).scrollTo();
        sleep(500);
        webTablesPage.clickEditButton(firstName);
        sleep(500);
    }

    @And("I update the department to {string}")
    public void i_update_the_department_to(String department) {
        webTablesPage.clearAndUpdateDepartment(department);
        sleep(500);
    }

    @Then("I should see the department {string} in the table")
    public void i_should_see_the_department_in_the_table(String department) {
        webTablesPage.getDepartmentCell(department).shouldBe(visible);
    }
}