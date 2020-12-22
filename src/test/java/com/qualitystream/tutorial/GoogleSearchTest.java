package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@After
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void testGooglePage() {
		
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("politecnico colombiano jaime isaza cadavid");
		searchbox.submit();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		assertEquals("politecnico colombiano jaime isaza cadavid - Buscar con Google", driver.getTitle());
		
		
		
	}

}
