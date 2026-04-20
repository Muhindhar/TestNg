package Selenium_TestNg_Demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_data {
	@DataProvider(name = "testdata",parallel=true)
	public Object[][] getData() {
	    return new Object[][] {
	        {"Selenium", "WebDriver"},
	        {"TestNG", "DataProvider"},
	        {"Java", "Automation"}
	    };
	}
  @Test
  public void f() {
  }
}
