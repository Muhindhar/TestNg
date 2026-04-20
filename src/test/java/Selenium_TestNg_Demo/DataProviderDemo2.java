package Selenium_TestNg_Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataProviderDemo2 {
    WebDriver driver;
    @Test(dataProvider = "testdata", dataProviderClass = DataProvider_data.class)
    public void search(String keyword) throws InterruptedException {
    	Thread.sleep(3000);
        WebElement txtbox = driver.findElement(By.name("q"));
        txtbox.sendKeys(keyword);  
        System.out.println("Keyword entered: " + keyword);
        System.out.println("Result displayed");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Start the test");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
        System.out.println("End the test");
    }
}