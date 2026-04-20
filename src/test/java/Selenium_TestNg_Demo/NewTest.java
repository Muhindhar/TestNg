package Selenium_TestNg_Demo;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class NewTest {
	public WebDriver driver;
	public WebDriverWait wait;
	
  @Test 
  public void Valid1() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  WebElement name =  driver.findElement(By.xpath("//input[@id='loginusername']"));
	  name.sendKeys("admin1");
	  WebElement ps =   driver.findElement(By.xpath("//input[@id='loginpassword']"));
	  ps.sendKeys("admin");
	  WebElement btn = driver.findElement(By.xpath("//button[text()='Log in']"));
	  btn.click();
         
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
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("12876");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[text()='Log in']")). click();
	  wait.until(ExpectedConditions.alertIsPresent());
	  Alert alert = driver.switchTo().alert();
	  String al = alert.getText();
	  String de = "User does not exist.";
	  alert.accept(); 
	  Assert.assertEquals(al,de);
	  System.out.println("Wrong username");
	  
  } 
  
  @Test
  public void valid2() {
	  driver.findElement(By.xpath("//a[@id='login2']")).click();
	  driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("admin");
	  driver.findElement(By.xpath("//button[text()='Log in']")). click();

  }
  
  @BeforeMethod
  public void beforeTest() {
	  ChromeOptions op = new ChromeOptions();
	  op.addArguments("--start-maximized");
	 op.addArguments("--headless");
	  driver = new ChromeDriver(op);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  driver.get("https://demoblaze.com/");  
  }
  @AfterMethod
  public void afterTest() {
	  driver.quit();
  }
}
