package org.mp;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickButtonTest {

    @Test
    public void shouldDisplayMessageWhenClickMeButtonIsClicked() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/elements");
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("#item-4")).click();
        Thread.sleep(2000);

        WebElement clickMeButton = driver.findElement(By.cssSelector("div.mt-4:nth-of-type(3) > button.btn.btn-primary"));
        clickMeButton.click();

        WebElement message = driver.findElement(By.cssSelector("#dynamicClickMessage"));
        Assert.assertEquals("You have done a dynamic click", message.getText());

        driver.quit();
    }

}
