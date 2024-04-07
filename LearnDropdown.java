package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {
	WebDriver driver;
	
	//Element list - By type/CLASS
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//*[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");
	By CUSTOMER_MENU_FIELD = By.xpath("/html/body/div[1]/aside[1]/div/nav/ul[2]/li[2]/a");
	By ADD_CUSTOMER_MENU_FIELD = By.xpath("//*[@id=\"customers\"]/li[2]/a/span");
	By NEW_CUSTOMER_HEADER_FIELD = By.xpath("/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong");
	By FULL_NAME_FIELD = By.xpath("//*[@id=\"general_compnay\"]/div[1]/label");
	By COMPANY_NAME_DROPDOWN_FIELD = By.xpath("//select[@name='company_name']");
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://codefios.com/ebilling/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	@Test
	public void LoginTest() {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		Assert.assertTrue("Dashboard not found!!",driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
	}
	@Test
	public void addCustomer() {
		LoginTest();
		driver.findElement(CUSTOMER_MENU_FIELD).click();
		driver.findElement(ADD_CUSTOMER_MENU_FIELD).click();
		Assert.assertTrue("Add Customer page is not available", driver.findElement(NEW_CUSTOMER_HEADER_FIELD).isDisplayed());
		driver.findElement(FULL_NAME_FIELD).sendKeys("Selenium");
		
		Select sel = new Select(driver.findElement(COMPANY_NAME_DROPDOWN_FIELD));
		//sel.selectByVisibleText("Techfios");
		//sel.selectByValue("Techfios");
		sel.selectByIndex(5);
		
		//Validation of all options available on a dropdown
		//1. Creating an array of options
		//2. getOption and convert into string
		//3. Advance for loop
	}
	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
