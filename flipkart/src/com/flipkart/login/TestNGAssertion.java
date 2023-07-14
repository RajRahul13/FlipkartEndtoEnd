package com.flipkart.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertion {
	@SuppressWarnings("deprecation")
	@Test
	public void TestAssert(){
		// TODO Auto-generated method stub
		String exePath = "C:\\Users\\rahul\\eclipse-workspace\\testNGProj\\Driver\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", exePath);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		String title = driver.getTitle();
		//Below line denotes the verification of title. It will stop the execution if title doesn’t match.
		Assert.assertEquals("The Internet", title);
		driver.close();
	}
}