package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class MyAccountsTest extends Utility {

    String url = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(url);
    }


    public void selectMyAccountOptions(String option) {

        if (option.equalsIgnoreCase("Register")) {
            driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();

            By confromation_text = By.xpath("//h1[normalize-space()='Register Account']");
            String expectedMessage = "Register Account";
            verifyText(expectedMessage, confromation_text);
        } else if (option.equalsIgnoreCase("Login")) {
            driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).click();

            By confromation_text = By.xpath("//h2[normalize-space()='Returning Customer']");
            String expectedMessage = "Returning Customer";
            verifyText(expectedMessage, confromation_text);
        } else if (option.equalsIgnoreCase("Logout")) {
            driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[5]")).click();

            By confromation_text = By.xpath("//h1[normalize-space()='Account Logout']");
            String expectedMessage = "Account Logout";
            verifyText(expectedMessage, confromation_text);
        }
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

        String register = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).getText();
        selectMyAccountOptions(register);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

        String login = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")).getText();
        selectMyAccountOptions(login);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {

        //3.1 Click on My Account Link.
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        verifyUserShouldNavigateToRegisterPageSuccessfully();

        //3.3 Enter First Name
        driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Mahesh");

        //3.4 Enter Last Name
        driver.findElement(By.xpath("//input[@id='input-lastname']")).sendKeys("Hirpara");

        //3.5 Enter Email
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mack312@gmail.com");

        //3.6 Enter Telephone
        driver.findElement(By.xpath("//input[@id='input-telephone']")).sendKeys("022928282818");

        //3.7 Enter Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Mack7!@");

        //3.8 Enter Password Confirm
        driver.findElement(By.xpath("//input[@id='input-confirm']")).sendKeys("Mack7!@");

        //3.9 Select Subscribe Yes radio button
        driver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();

        //3.10 Click on Privacy Policy check box
        driver.findElement(By.xpath("//input[@name='agree']")).click();

        //3.11 Click on Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();


        //3.12 Verify the message “Your Account Has Been Created!”
        By register_message = By.xpath("//h1[normalize-space()='Your Account Has Been Created!']");
        String expectedMessage = "Your Account Has Been Created!";
        verifyText(expectedMessage, register_message);

        //3.13 Click on Continue button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        //3.14 Click on My Account Link.
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //3.16 Verify the text “Account Logout”
        String logout = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[5]")).getText();
        selectMyAccountOptions(logout);

        //3.17 Click on Continue button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

        //4.1 Click on My Account Link.
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        verifyUserShouldNavigateToLoginPageSuccessfully();

        //4.3 Enter Email address
        driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("mack312@gmail.com");

        //4.5 Enter Password
        driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Mack7!@");


        //4.6 Click on Login button
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        //4.7 Verify text “My Account”
        By account_message = By.xpath("//h2[normalize-space()='My Account']");
        String expectedMessage = "My Account";
        verifyText(expectedMessage, account_message);

        //4.8 Click on My Account Link.
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();

        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        //4.10 Verify the text “Account Logout”
        String logout = driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li[5]")).getText();
        selectMyAccountOptions(logout);

        //4.11 Click on Continue button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
    }
    @After
    public void close() {
        closeBrowser();
    }
}