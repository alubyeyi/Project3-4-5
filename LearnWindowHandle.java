package variousConcepts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnWindowHandle {
WebDriver driver;

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
	public void testWindowHandle() {
	String title1 = driver.getTitle();
	System.out.println(title1);
	String handle1 = driver.getWindowHandle();
	System.out.println(handle1);
	
	driver.findElement(By.xpath("//*[@id='ybar-sbq']")).sendKeys("selenium");
	driver.findElement(By.xpath("//*[@id='ybar-search']")).click();
	
	String title2 = driver.getTitle();
	System.out.println(title2);
	String handle2 = driver.getWindowHandle();
	System.out.println(handle2);
	
	//driver.findElement(By.xpath("check later")).click();
	//Set<String> handles = driver.getWindowHandle();
	//System.out.println(handles);
	//for(String str : handles) {
	//	System.out.println(str);
	//	driver.switchTo().window(str);
	}
	
	//String title3 = driver.getTitle();
	//System.out.println(title3);
		
	}




