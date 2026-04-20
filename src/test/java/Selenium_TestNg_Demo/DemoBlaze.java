package Selenium_TestNg_Demo;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoBlaze {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeTest() {
        String browser = "chrome";  
        String url = "https://www.demoblaze.com";
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get(url);
    }

    @DataProvider(name = "logindata")
    public Object[][] getData() {
        return new Object[][]{
                {"muhi", "admin"}, 
                {"admin","233"},
                {"admin","admin"}
               };
    		}
    @Test(dataProvider = "logindata")
    public void loginTest(String username, String password) {
        driver.findElement(By.id("login2")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")))
                .sendKeys(username);
        driver.findElement(By.id("loginpassword")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        WebElement check = driver.findElement(By.xpath("//a[@id='cat']"));   
        wait.until(ExpectedConditions.alertIsPresent());
       	Alert alert = driver.switchTo().alert();
       	alert.accept();    
       	if(check.isDisplayed()) {
       		System.out.println("Success");
       	}
       	String a = check.getText();
       	Assert.assertEquals(check, a);
    }
    @Test
    public void Invalid1() {
  	  driver.findElement(By.xpath("//a[@id='login2']")).click();
  	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("muhi");
  	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("muhi112");
  	  driver.findElement(By.xpath("//button[text()='Log in']")). click();
  	  wait.until(ExpectedConditions.alertIsPresent());
  	  Alert alert = driver.switchTo().alert();
  	  String al = alert.getText();
  	  String de = "Wrong password.";
  	  alert.accept(); 
  	  Assert.assertEquals(al,de);
  	  System.out.println("Wrong password");
    }
    @Test
    public void Invalid2() {
  	  driver.findElement(By.xpath("//a[@id='login2']")).click();
  	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("muhi");
  	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("admin");
  	  driver.findElement(By.xpath("//button[text()='Log in']")). click();
  	  wait.until(ExpectedConditions.alertIsPresent());
  	  Alert alert = driver.switchTo().alert();
  	  String al = alert.getText();
  	  String de = "Wrong password.";
  	  alert.accept();
  	  Assert.assertEquals(al,de);
  	  System.out.println("Wrong Username.");
    }
    @AfterMethod
    public void afterTest() {
        driver.quit();
    }
}