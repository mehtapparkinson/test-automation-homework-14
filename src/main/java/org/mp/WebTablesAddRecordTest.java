package org.mp;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class WebTablesAddRecordTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
    }

    private void fillFormAndSubmit(String firstName, String lastName, String email, String age, String salary, String department) {
        driver.findElement(By.cssSelector("#addNewRecordButton")).click();
        driver.findElement(By.cssSelector("#firstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#lastName")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#userEmail")).sendKeys(email);
        driver.findElement(By.cssSelector("#age")).sendKeys(age);
        driver.findElement(By.cssSelector("#salary")).sendKeys(salary);
        driver.findElement(By.cssSelector("#department")).sendKeys(department);
        driver.findElement(By.cssSelector("#submit")).click();
    }

    @Test
    public void testAddRecord() {

        fillFormAndSubmit("Mehtap", "Parkinson", "mehtap@parkinson.com", "31", "1000", "Engineering");

        WebElement addedRecord = driver.findElement(
                By.xpath("//div[@class='rt-td' and text()='Mehtap']")
        );

        Assert.assertTrue(addedRecord.isDisplayed());
    }

    @Test
    public void testEditRecord() {

        fillFormAndSubmit("Mehtap", "Parkinson", "mehtap@parkinson.com", "31", "1000", "Engineering");

        WebElement editButton = driver.findElement(
                By.xpath("//span[@id='edit-record-4']")
        );
        editButton.click();

        WebElement departmentInput = driver.findElement(By.cssSelector("#department"));
        departmentInput.clear();
        departmentInput.sendKeys("QA");
        driver.findElement(By.cssSelector("#submit")).click();

        WebElement updatedDepartment = driver.findElement(
                By.xpath("//div[@class='rt-td' and text()='QA']")
        );

        Assert.assertTrue(updatedDepartment.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
