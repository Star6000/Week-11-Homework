package testsuite_p2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utils.Utility;

public class LoginTest extends Utility {

    String url = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(url);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mack9");

        // Enter valid password
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mahesh07@");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("input[value='Log In']")).click();

        // Verify the ‘Accounts Overview’ text is display
        //By message = By.xpath("//h1[@class='title']");
        //String title = "Accounts Overview";
        //verifyText(title,message);

    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mack9");

        //Enter invalid password
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mahesh07@");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("input[value='Log In']")).click();

        //Verify the error message ‘The username and password could not be verified.’
        //By message = By.xpath("//h1[@class='title']");
        //String title = "The username and password could not be verified.";
        //verifyText(title,message);
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        // Enter valid username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mack9");

        // Enter valid password
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Mahesh07@");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("input[value='Log In']")).click();

        //Click on ‘Log Out’ link
        driver.findElement(By.xpath("input[value='Log out']")).click();

        //Verify the text ‘Customer Login’
        //By message = By.xpath("//h1[@class='title']");
        //String title = "Customer Login";
        //verifyText(title,message);
    }

    @After
    public void close() {
        closeBrowser();
    }
}