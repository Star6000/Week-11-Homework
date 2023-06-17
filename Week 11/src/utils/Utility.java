package utils;

import broswertesting.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    public void clickOnElement(By by) {
        WebElement element = driver.findElement(by);
        element.click();
    }

    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();// Return text
    }

    public void verifyText(String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(expectedMessage,actualMessage);
    }


    // This method will mouse hover and click the element
    public void mouseHoverToElementAndClick(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        //   Thread.sleep(3000);
        //  waitUnitVisibilityOfElementLocated(by,
        actions.moveToElement(mouseHoover).click().build().perform();
    }

    // This method will mouse hover on element
    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        actions.moveToElement(mouseHoover).build().perform();
    }

    public void mouseHoverAndClick(By by,By by1) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        WebElement mouseHoover1=driver.findElement(by1);
        actions.moveToElement(mouseHoover).moveToElement(mouseHoover1).click().build().perform();
    }

    public String mouseHoverAndClickAndReturn(By by,By by1) throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement mouseHoover = driver.findElement(by);
        WebElement mouseHoover1= driver.findElement(by1);
        System.out.println("--------text------"+mouseHoover1.getText());
        actions.moveToElement(mouseHoover).moveToElement(mouseHoover1).click().build().perform();
        return mouseHoover1.getText();
    }

    public void selectByValueFromDropdown(By by, String value) {
        WebElement dropdown = driver.findElement(by);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void selectByVisibleTextFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }

    // This method will clear text from field
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }

    // This method will send text to element
    public void sendKeysToElement(By by, CharSequence keys)
    {
        driver.findElement(by).sendKeys(keys);
    }

    // This method will send text to elements
    public void sendTextToElement(By by, String text) {
        WebElement element=driver.findElement(by);
        element.sendKeys(text);
    }



}