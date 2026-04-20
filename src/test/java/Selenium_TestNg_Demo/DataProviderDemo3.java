package Selenium_TestNg_Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo3 {
	public static final ThreadLocal <WebDriver> driver = new 
			ThreadLocal <WebDriver>();
	
  @Test(dataProvider = "testdata",dataProviderClass= DataProvider_data.class)
  
  public void f(String keyword1, String keyword2) {
	  WebDriver driver1 = driver.get();
	  driver1.get("https://www.google.com");
	  WebElement txtbox = driver1.findElement(By.name("q"));
      txtbox.sendKeys(keyword1);  
      System.out.println("Keyword entered: " + keyword1 );
      txtbox.sendKeys(Keys.ENTER);
      System.out.println("Result displayed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Start the test");
	  driver.set(new ChromeDriver());
  }

  @AfterMethod
  public void afterMethod() {
	  WebDriver driver1 = driver.get();
	  System.out.println("After thread id : "+Thread.currentThread().getId());
	  if(driver1 != null) {
		  driver1.quit();
	  }
  }

}
