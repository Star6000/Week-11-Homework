package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String url = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(url);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        By mouseHoverLeptops = By.xpath("//a[normalize-space()='Laptops & Notebooks']");
        By mouseClickShowLaptops = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']");

        mouseHoverAndClick(mouseHoverLeptops, mouseClickShowLaptops);

        By selectFromDropDown = By.xpath("//select[@id='input-sort']");
        String selectValue = "Price (High > Low)";
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);
        Thread.sleep(5000);
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        // 2.1 to 2.3
        verifyProductsPriceDisplayHighToLowSuccessfully();

        // 2.4 Select product “MacBook”
        By select_MacBook_Product = By.xpath("//div[@class='image']//img[@title='MacBook']");
        clickOnElement(select_MacBook_Product);


        // 2.5 Verify the Text "MacBook"
        By confromation_text = By.xpath("//h1[normalize-space()='MacBook']");
        String expectedMessage = "MacBook";
        verifyText("MacBook", confromation_text);

        //2.6 Click on ‘Add To Cart’ button
        driver.findElement(By.xpath("//button[@id='button-cart']")).click();

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        By sucess_message_xpath = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        String expectedMessage1 = " Success: You have added MacBook to your shopping cart!\n" + "×";
        //verifyText(expectedMessage1, sucess_message_xpath);

        //2.8 Click on link “shopping cart” display into success message
        driver.findElement(By.xpath("//a[normalize-space()='shopping cart']")).click();

        //2.9 Verify the text "Shopping Cart"
        By shopping_xpath = By.xpath("//a[contains(text(),'Shopping Cart')]");
        String expectedMessage_shopping = "Shopping Cart";
        verifyText(expectedMessage_shopping, shopping_xpath);

        //2.10 Verify the Product name "MacBook" //
        By Product_xpath = By.xpath("//div[@class='table-responsive']//table[@class='table table-bordered']//tbody//td[2]");
        String expectedMessage_MacBook = "MacBook";
        //verifyText(expectedMessage_MacBook, Product_xpath);


        //2.11 Change Quantity "2"
//        By Qty = By.xpath("//input[@name='quantity[25073]']");
//        clearTextFromField(Qty);
//        sendTextToElement(Qty,"2");
//        Thread.sleep(3000);

        //2.12 Click on “Update”Tab
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //2.13 Verify the message “Success: You have modified your shopping cart!”
        By Update_xpath = By.xpath("//div[@class='alert alert-success alert-dismissible']");
        String expectedMessage_update = "Success: You have modified your shopping cart!";
        //verifyText(expectedMessage_update, Update_xpath);

        //2.14 Verify the Total £737.45
        By total_xpath = By.xpath("//div[@class='row']//div[@class='col-sm-4 col-sm-offset-8']//table[@class='table table-bordered']//tr[4]//td[2]");
        String expectedMessage_total = "£1024.45";
        //verifyText(expectedMessage_total, total_xpath);

        //2.15 Click on “Checkout” button
        driver.findElement(By.xpath("a[class='btn btn-primary']")).click();

        //2.16 Verify the text “Checkout”
        By Checkout_xpath = By.xpath("//h1[normalize-space()='Checkout']");
        String expectedMessage_checkout = "Checkout";
        verifyText(expectedMessage_checkout, Checkout_xpath);

        //2.17 Verify the Text “New Customer”
        By NewCustomer_xpath = By.xpath("//h2[normalize-space()='New Customer']");
        String expectedMessage_newCustomer = "New Customer";
        verifyText(expectedMessage_newCustomer, NewCustomer_xpath);

        //2.18 Click on “Guest Checkout” radio button
        driver.findElement(By.xpath("//input[@value='guest']")).click();

        //2.19 Click on “Continue” tab
        driver.findElement(By.xpath("//input[@id='button-account']")).click();

        //2.20 Fill the mandatory fields
        driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Mahesh");
        driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("Hirpara");
        driver.findElement(By.xpath("//input[@id='input-payment-email']")).sendKeys("mahesh07.ap@gmail.com");
        driver.findElement(By.xpath("//input[@id='input-payment-telephone']")).sendKeys("02388864427");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("10 Headlife road");
        driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("London");
        driver.findElement(By.xpath("//input[@id='input-payment-postcode']")).sendKeys("SW12 EDW");

        Thread.sleep(2000);
        // select country from the dropdown list
        By selectFromDropDown = By.xpath("//select[@id='input-payment-country']");
        String selectValue = "United Kingdom";
        selectByVisibleTextFromDropDown(selectFromDropDown, selectValue);

        By selectFromDropDownState = By.xpath("//select[@id='input-payment-zone']");
        String selectStateValue = "United Kingdom";
        selectByVisibleTextFromDropDown(selectFromDropDownState, selectStateValue);

        Thread.sleep(2000);
        //2.21 Click on “Continue” Button
        driver.findElement(By.xpath("//input[@id='button-guest']")).click();

        //2.22 Add Comments About your order into text area
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Test");

        //2.23 Check the Terms & Conditions check box
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();

        //2.24 Click on “Continue” button
        driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();

        //2.25 Verify the message “Warning: Payment method required!”
        By Warning_xpath = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
        String expectedMessage_Warning = "Warning: Payment method required!";
        verifyText(expectedMessage_Warning, Warning_xpath);

    }

    @After
    public void close(){
        closeBrowser();
    }
}