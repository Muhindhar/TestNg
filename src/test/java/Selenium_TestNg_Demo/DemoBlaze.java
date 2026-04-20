package Selenium_TestNg_Demo;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoAlertPresentException;

import java.time.Duration;

public class DemoBlaze {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.demoblaze.com");
    }

    @DataProvider(name = "logindata")
    public Object[][] getData() {
        return new Object[][]{
                {"muhi", "admin"},
                {"admin", "233"},
                {"admin", "admin"}
        };
    }

    @Test(dataProvider = "logindata")
    public void loginTest(String username, String password) throws InterruptedException {

        driver.findElement(By.id("login2")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))).sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        if (isAlertPresent()) {
            Alert alert = driver.switchTo().alert();
            String msg = alert.getText();
            alert.accept();
            System.out.println("Login Failed: " + msg);
            Assert.assertTrue(msg.contains("Wrong"));
        } else {
            WebElement user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
            String text = user.getText();
            System.out.println("Login Success: " + text);
            Assert.assertTrue(text.contains("Welcome"));
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}
