package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnScroll {
WebDriver driver;
	
	//Element list - By type/CLASS
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//*[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");
	By COM_ACCESS_FIELD = By.xpath("//span[contains(text(),'Computers & Accessories')]");
	By MONITORS_FIELD = By.xpath("//button[text()='Monitors']");		
	By ALL_MONITORS_FIELD = By.xpath("//a[text()='View All Monitors']");		
			
	
	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.dell.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);	
	}
	@Test
	public void testScroll() {
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("scroll 0,7000");
		
	}


}
