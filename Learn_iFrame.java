package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Learn_iFrame {
WebDriver driver;
	
	//Element list - By type/CLASS
	By USER_NAME_FIELD = By.xpath("//input[@id='user_name']");
	By PASSWORD_FIELD = By.xpath("//input[@id='password']");
	By SIGNIN_BUTTON_FIELD = By.xpath("//*[@id='login_submit']");
	By DASHBOARD_HEADER_FIELD = By.xpath("/html/body/div[1]/header/nav/div[2]/ul[1]/li[2]/a");
	
	
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
	public void testIFrame() throws InterruptedException {
		driver.findElement(USER_NAME_FIELD).sendKeys("demo@codefios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(SIGNIN_BUTTON_FIELD).click();
		
		Assert.assertTrue("Dashboard not found!!",driver.findElement(DASHBOARD_HEADER_FIELD).isDisplayed());
		
		driver.switchTo().frame("advertisement");
		driver.findElement(By.xpath("//div[@id='ad_three']")).click();
		
		driver.switchTo().frame("portals");
		driver.findElement(By.xpath("//di v[@id='portal_two']")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//div[@id='ad_four']")).click();
	
	}
	

}
