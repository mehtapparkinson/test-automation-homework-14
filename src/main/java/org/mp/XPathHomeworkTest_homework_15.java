package org.mp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathHomeworkTest_homework_15 {

    @Test
    public void test1_ClickButton() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
        Thread.sleep(2000);

        WebElement buttonsOption = driver.findElement(By.xpath("//span[text()='Buttons']"));

        buttonsOption.click();
        Thread.sleep(2000);

        WebElement clickMeButton = driver.findElement(By.xpath("//button[text()='Click Me']"));
        clickMeButton.click();
        Thread.sleep(1000);

        WebElement message = driver.findElement(By.xpath("//p[@id='dynamicClickMessage']"));
        Assert.assertEquals("You have done a dynamic click", message.getText());

        driver.quit();
    }

    @Test
    public void test2_AddRecord() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Mehtap");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Parkinson");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mehtap@parkinson.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("31");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Engineering");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);

        WebElement addedRecord = driver.findElement(By.xpath("//div[@class='rt-td' and text()='Mehtap']"));
        Assert.assertTrue(addedRecord.isDisplayed());
        Thread.sleep(1000);

        driver.quit();
    }

    @Test
    public void test3_EditRecord() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='addNewRecordButton']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Mehtap");
        driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Parkinson");
        driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("mehtap@parkinson.com");
        driver.findElement(By.xpath("//input[@id='age']")).sendKeys("31");
        driver.findElement(By.xpath("//input[@id='salary']")).sendKeys("1000");
        driver.findElement(By.xpath("//input[@id='department']")).sendKeys("Engineering");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);

        WebElement editButton = driver.findElement(
                By.xpath("//div[text()='Mehtap']/parent::div/parent::div//span[@title='Edit']")
        );
        editButton.click();
        Thread.sleep(1000);

        WebElement departmentInput = driver.findElement(By.xpath("//input[@id='department']"));
        departmentInput.clear();
        departmentInput.sendKeys("QA");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);

        WebElement updatedDepartment = driver.findElement(
                By.xpath("//div[@class='rt-td' and text()='QA']")
        );
        Assert.assertTrue(updatedDepartment.isDisplayed());

        driver.quit();
    }
}