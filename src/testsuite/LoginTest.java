package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = " https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username in username field
        driver.findElement(By.name("username")).sendKeys("Admin");
        //Enter password in password field
        driver.findElement(By.name("password")).sendKeys("admin123");
        //click on login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        loginBtn.click();
        //verify the 'Dashboard' text is display
        String expectedTextDisplay = "Dashboard";
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("Text is Display", expectedTextDisplay, actualTextDisplay);
    }

    //@After
    //public void tearDown(){
    //    closeBrowser();
    // }
}
