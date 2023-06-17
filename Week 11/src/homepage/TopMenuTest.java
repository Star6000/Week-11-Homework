package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        System.out.println("Current Menu : " + menu);

        if (menu.equalsIgnoreCase("Show AllDesktops")) {
            String actualDesktop = "Desktops"; //
            String exceptedDesktop = driver.findElement(By.xpath("//a[normalize-space()='Desktops']")).getText();
            Assert.assertEquals(actualDesktop, exceptedDesktop);
        }

        if (menu.equalsIgnoreCase("Show AllLaptops & Notebooks")) {
            String exceptedLaptopNotebooks = driver.findElement(By.xpath("//h2[normalize-space()='Laptops & Notebooks']")).getText();
            String actualLaptopsNotebooks = "Laptops & Notebooks";
            Assert.assertEquals(actualLaptopsNotebooks, exceptedLaptopNotebooks);
        }

        if (menu.equalsIgnoreCase("Components")) {
            String exceptedComponents = driver.findElement(By.xpath("//h2[normalize-space()='Components']")).getText();
            String actualComponents = "Components";
            Assert.assertEquals(actualComponents, exceptedComponents);
        }
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement leptopsNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        actions.moveToElement(leptopsNotebooks).perform();
        WebElement showAllLeptopNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        String pass = showAllLeptopNotebooks.getText();
        actions.click(showAllLeptopNotebooks).perform();
        selectMenu(pass);

        // Method 2
//
//        By mouseHoverDesktops = By.xpath("//a[normalize-space()='Desktops']");              // Desktops Xpath
//        By mouseClickShowDesktops = By.xpath("//a[normalize-space()='Show AllDesktops']"); // ShowALlDesktops Xpath
//        String title = mouseHoverAndClickAndReturn(mouseHoverDesktops,mouseClickShowDesktops);
//        selectMenu(title);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement leptopsNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        actions.moveToElement(leptopsNotebooks).perform();
        WebElement showAllLeptopNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        String pass = showAllLeptopNotebooks.getText();
        System.out.println("--------------PASS------------"+pass);
        actions.click(showAllLeptopNotebooks).perform();
        selectMenu(pass);

        // Method 2

        // By mouseHoverLeptopAndNoteBook = By.xpath("//a[normalize-space()='Laptops & Notebooks']");              // LeptopAndNoteBook Xpath
//        By mouseClickShowLeptopAndNoteBook = By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"); // ShowALlLeptopAndNoteBook Xpath
//        WebElement showAllLeptopNotebooks = driver.findElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
//        String pass = showAllLeptopNotebooks.getText();
//        System.out.println("---------PASS----------"+pass);
//        String title = mouseHoverAndClickAndReturn(mouseHoverLeptopAndNoteBook,mouseClickShowLeptopAndNoteBook);
//        selectMenu(title);

    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {

        Actions actions = new Actions(driver);//a[normalize-space()='Components']
        WebElement components = driver.findElement(By.xpath("//a[normalize-space()='Components']"));
        actions.moveToElement(components).perform();
        WebElement showComponents = driver.findElement(By.xpath("//a[normalize-space()='Show AllComponents']"));
        String passComponents = showComponents.getText();
        actions.click(showComponents).perform();
        selectMenu(passComponents);

        // Method 2
//        By mouseHoverComponentsTab = By.xpath("//a[normalize-space()='Components']");              // Components Xpath
//        By mouseClickShowComponents = By.xpath("//a[normalize-space()='Show AllComponents']"); // Showomponents Xpath
//        String title = mouseHoverAndClickAndReturn(mouseHoverComponentsTab,mouseClickShowComponents);
//        selectMenu(title);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}