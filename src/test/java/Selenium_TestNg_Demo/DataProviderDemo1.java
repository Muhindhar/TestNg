package Selenium_TestNg_Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DataProviderDemo1  {
	WebDriver driver;
	@DataProvider(name="testdata")
	public Object[][] dataprovFunc(){
		return new Object[][] {
			{"Selenium"},{"TestNg"}
		};
	}
  @Test(dataProvider="testdata")
  public void search(String keyword) {
	  WebElement txtbox = driver.findElement(By.id("sb_form_q"));
	  txtbox.sendKeys("keyword");
	  System.out.println("Keyword entered : "+keyword);
	  txtbox.sendKeys(keyword);
	  System.out.println("Result displayed");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Start the test");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
	  System.out.println("End the test");
  }

}
