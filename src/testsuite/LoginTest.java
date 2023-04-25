package testsuite;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String basUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(basUrl);
    }
    @Test
    public void userShouldLoginWithValidCredentials(){
        // Enter “standard_user” username
      sendTextToElement(By.id("user-name"),"standard_user");
      // Enter “secret_sauce” password
      sendTextToElement(By.name("password"),"secret_sauce");
      // Click on ‘LOGIN’ button
       clickOnElement(By.xpath("//input[@type='submit']"));

       //Verify the text “PRODUCTS”
        String expectedText = "Products";
        String actualText = getTextFromElement(By.xpath("//span[text()='Products']"));
       // Validate actual and expected result
        Assert.assertEquals("Text not found", expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter “standard_user” username
        sendTextToElement(By.id("user-name"),"standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.name("password"),"secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@type='submit']"));

        // Verify that six products are displayed on page
        // 1st product
        String expectedProduct1 = "Sauce Labs Backpack";
        String actualProduct1 = getTextFromElement((By.xpath("//div[text()='Sauce Labs Backpack']")));
        // Validate actual and expected result
        Assert.assertEquals("Product not found",expectedProduct1,actualProduct1);

        // 2nd product
        String expectedProduct2 = "Sauce Labs Bike Light";
        String actualProduct2 = getTextFromElement((By.xpath("//div[text()='Sauce Labs Bike Light']")));
        // Validate actual and expected result
        Assert.assertEquals("Product not found",expectedProduct2,actualProduct2);

        // 3rd product
        String expectedProduct3 = "Sauce Labs Bolt T-Shirt";
        String actualProduct3 = getTextFromElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        // Validate actual and expected result
        Assert.assertEquals("Product not found",expectedProduct3,actualProduct3);

        // 4th product
        String expectedProduct4 = "Sauce Labs Fleece Jacket";
        String actualProduct4 = getTextFromElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));
        // Validate actual and expected result
        Assert.assertEquals("Product not found",expectedProduct4,actualProduct4);

        // 5th product
        String expectedProduct5 = "Sauce Labs Onesie";
        String actualProduct5 = getTextFromElement(By.xpath("//div[text()='Sauce Labs Onesie']"));
        // Validate actual and expected result
        Assert.assertEquals("Product not found",expectedProduct5,actualProduct5);

        // 6th product
        String expectedProduct6 = "Test.allTheThings() T-Shirt (Red)";
        String actualProduct6 = getTextFromElement(By.xpath("//div[text()='Test.allTheThings() T-Shirt (Red)']"));
        // Validate actual and expected result
        Assert.assertEquals("Product not found",expectedProduct6,actualProduct6);

    }
  public void closeBrowser(){
        driver.quit();
  }

}
