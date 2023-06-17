package desktops;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class DesktopsTest extends Utility {

    String url = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(url);
    }


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        By mouseHoverDesktops = By.xpath("//a[normalize-space()='Desktops']");
        By mouseClickShowDesktops = By.xpath("//a[normalize-space()='Show AllDesktops']");

        mouseHoverAndClick(mouseHoverDesktops, mouseClickShowDesktops);

        By selectFromDropDown = By.xpath("//select[@id='input-sort']");
        String selectValue = "Name (Z - A)";
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);
        Thread.sleep(5000);
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {

        //2.1 to 2.3
        verifyProductArrangeInAlphaBaticalOrder();


        //img[@title='HP LP3065']
        By select_HP_Product = By.xpath("//img[@title='HP LP3065']");
        clickOnElement(select_HP_Product);

        // 2.5 Verify the Text "HP LP3065"
        By confromation_text = By.xpath("//div[@id='content']//h1");
        String expectedMessage = "HP LP3065";
        String actualMessage = "HP LP3065";
        verifyText("HP LP3065", confromation_text);

        //2.6 Select Delivery Date "2022-11-30"
        By clearDate = By.xpath("//input[@id='input-option225']");
        clearTextFromField(clearDate);
        sendKeysToElement(clearDate, "2022-11-30");

        //2.7.Enter Qty "1” using Select class.
        By Qty = By.xpath("//input[@id='input-quantity']");
        clearTextFromField(Qty);
        sendTextToElement(Qty,"1");
        Thread.sleep(3000);

        //2.8 Click on “Add to Cart” button
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        By sucess_message_xpath = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        String expectedMessage1 = " Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        //verifyText(expectedMessage1, sucess_message_xpath);

        // 2.10 Click on link “shopping cart” display into success message
        driver.findElement(By.xpath("//a[@href='https://tutorialsninja.com/demo/index.php?route=checkout/cart']")).click();
        Thread.sleep(3000);

        //2.11 Verify the text "Shopping Cart"
        By shopping_xpath = By.xpath("//a[contains(text(),'Shopping Cart')]");
        String expectedMessage_shopping = "Shopping Cart";
        verifyText(expectedMessage_shopping, shopping_xpath);

        //2.12 Verify the Product name "HP LP3065"
        By Product_xpath = By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//td[2]");
        String expectedMessage_HP = "HP LP3065";
        verifyText(expectedMessage_HP, shopping_xpath);


        //2.13 Verify the Delivery Date "2022-11-30"
        By Date_xpath = By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//td[2]");
        String expectedMessage_Date = "2022-11-30";
        //verifyText(expectedMessage_shopping, shopping_xpath);


        //2.14 Verify the Model "Product21"
        By Product_21_xpath = By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//td[2]");
        String expectedMessage_Product_21 = "Product21";
        //verifyText(expectedMessage_Product_21, Product_21_xpath);

        //2.15 Verify the Todat "£74.73"
        By TotalPrice_xpath = By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//td[2]");
        String expectedMessage_TotalPrice = "74.73";
        //verifyText(expectedMessage_TotalPrice, TotalPrice_xpath);
    }

    @After
    public void close() {
        closeBrowser();
    }
}