package testsuite_p2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class RegisterTest extends Utility {
    String url = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setup(){
        openBrowser(url);
    }
    @Test
    public void verifyThatSigningUpPageDisplay() throws InterruptedException {
        // click on the ‘Register’ link
        driver.findElement(By.xpath("//a[normalize-space()='Register']")).click();

        // Verify the text ‘Signing up is easy!’
        By message = By.xpath("//h1[@class='title']");
        String title = "Signing up is easy!";
        verifyText(title,message);
    }
    @Test
    public void userShouldRegisterAccountSuccessfully() throws InterruptedException {
        //click on the ‘Register’ link
        verifyThatSigningUpPageDisplay();

        //Enter First name
        driver.findElement(By.xpath("//input[@id='customer.firstName']")).sendKeys("Mayur");

        //Enter Last name
        driver.findElement(By.xpath("//input[@id='customer.lastName']")).sendKeys("Patel");

        //Enter Address
        driver.findElement(By.xpath("//input[@id='customer.address.street']")).sendKeys("21 BOX park, Cernter park");

        //Enter City
        driver.findElement(By.xpath("//input[@id='customer.address.city']")).sendKeys("Ahmedabad");

        //Enter State
        driver.findElement(By.xpath("//input[@id='customer.address.state']")).sendKeys("Gujarat");

        //Enter Zip Code
        driver.findElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys("CDH 21D");

        //Enter Phone
        driver.findElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys("02349282918");

        //Enter SSN
        driver.findElement(By.xpath("//input[@id='customer.ssn']")).sendKeys("JH87GFSHA");

        //Enter Username
        driver.findElement(By.xpath("//input[@id='customer.username']")).sendKeys("Mack9");

        //Enter Password
        driver.findElement(By.xpath("//input[@id='customer.password']")).sendKeys("Mahesh07@");

        //Enter Confirm
        driver.findElement(By.xpath("//input[@id='repeatedPassword']")).sendKeys("Mahesh07@");

        //Click on REGISTER button
        driver.findElement(By.xpath("//input[@value='Register']")).click();

        //Verify the text 'Your account was created successfully. You are now logged in.’
        //p[contains(text(),'Your account was created successfully. You are now')]
        By message = By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]");
        String title = "Your account was created successfully. You are now logged in.";
        verifyText(title,message);

    }

    @After
    public void close(){
        closeBrowser();
    }
}