package org.mp.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class WebTablesPage {

    private SelenideElement addButton = $x("//button[@id='addNewRecordButton']");

    private SelenideElement firstNameInput = $x("//input[@id='firstName']");
    private SelenideElement lastNameInput = $x("//input[@id='lastName']");
    private SelenideElement emailInput = $x("//input[@id='userEmail']");
    private SelenideElement ageInput = $x("//input[@id='age']");
    private SelenideElement salaryInput = $x("//input[@id='salary']");
    private SelenideElement departmentInput = $x("//input[@id='department']");
    private SelenideElement submitButton = $x("//button[@id='submit']");

    public void clickAddButton() {
        addButton.click();
    }

    public void fillForm(String firstName, String lastName, String email,
                         String age, String salary, String department) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);
        emailInput.setValue(email);
        ageInput.setValue(age);
        salaryInput.setValue(salary);
        departmentInput.setValue(department);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public SelenideElement getRecordByFirstName(String firstName) {
        return $x("//div[@class='rt-td' and text()='" + firstName + "']");
    }

    public void clickEditButton(String firstName) {
        $x("//div[text()='" + firstName + "']/parent::div/parent::div//span[@title='Edit']").click();
    }

    public void clearAndUpdateDepartment(String newDepartment) {
        departmentInput.clear();
        departmentInput.setValue(newDepartment);
    }

    public SelenideElement getDepartmentCell(String department) {
        return $x("//div[@class='rt-td' and text()='" + department + "']");
    }
}