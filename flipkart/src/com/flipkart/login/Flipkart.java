package com.flipkart.login;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart{
	WebDriver driver;
    WebDriverWait wait;
	@BeforeMethod
	public void launchbrowser() throws InterruptedException {
		String exePath = "C:\\Users\\rahul\\eclipse-workspace\\testNGProj\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();

		//Navigate to the given URL https://www.flipkart.com/
		driver.get("https://www.flipkart.com/");

		//maximizing window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
	}
	@Test
	public void Flipkartflow() throws InterruptedException {
		
		//closing login modal
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement crossBTN = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		crossBTN.click();
		
		//click mobile icon
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement mobile_BTN = driver.findElement(By.xpath("//img[@alt='Mobiles']"));
		mobile_BTN.click();
		
		//hover over to electronicssection
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement ElectronicBTNhover = driver.findElement(By.xpath("(//span[@class='_2I9KP_'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ElectronicBTNhover).build().perform();
		
		//clicking on mi
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//a[@title='Mi']")).click();
		
		//sliding the price slider
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until((ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='_3FdLqY'])[2]"))));
		WebElement slider = driver.findElement(By.xpath("(//div[@class='_3FdLqY'])[1]"));
		int xwidth = slider.getSize().width;
		action.dragAndDropBy(slider,xwidth*3,0).build().perform();
	
		//Searchfor“redmi go (black, 8 gb)”in the search bar
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement searchBox = driver.findElement(By.xpath("//input[@title=\"Search for products, brands and more\"]"));
		searchBox.sendKeys("redmi go (black, 8 gb)"+Keys.ENTER);
		
		//Click on the first product displayed on the screen
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		WebElement product = driver.findElement(By.xpath("//div[contains(text(),\"Redmi Go (Black, 8 GB)\")]"));
		Set<String> windowHandles = driver.getWindowHandles();
		Thread.sleep(2000);
		product.click();
		
		Set<String> updatedWindowHandles = driver.getWindowHandles();
	    updatedWindowHandles.removeAll(windowHandles);
	    for (String window: updatedWindowHandles) {
	    	//Verify that the product amount should be greater than or equal to0 (Use switchto new window)
	        driver.switchTo().window(window);
			Thread.sleep(2000);
			//Hover on the image thumbnail which displays play video icon
			WebElement videoICON = driver.findElement(By.xpath("//div[@class='_3g-Cpg']"));
			System.out.println(videoICON.getAttribute("class"));
			action.moveToElement(videoICON).build().perform();
			Thread.sleep(5000);
			
			//entering value in delivery text
			driver.findElement(By.xpath("//input[@id='pincodeInputId']")).sendKeys("110030");
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div//span[@class='_2P_LDn']")).click();
			Thread.sleep(3000);
			
			//Click on “View Details”link under the Delivery pincode and verify that the modal pop up is opened or not. Close theModal(Use Modal )
			driver.findElement(By.xpath("//div//span[@class='YxlyDn']")).click();
			Thread.sleep(3000);
			//closing modal
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[1]/div/button")).click();
			Thread.sleep(3000);
			
			//adding item in cart
			driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[1]/div[2]/div/ul/li[1]/button")).click();
			
	    }

	}
		@AfterMethod
		public void closeBrowser() {
		driver.close();
		driver.quit();
	}		
}
