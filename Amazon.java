package test;

import java.time.Duration;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//Step 1 - Open https://www.amazon.in/.
		
		String amazonUrl = "https://www.amazon.in/";
		driver.get(amazonUrl);
		String currentUrl = driver.getCurrentUrl();
		
		if(currentUrl.equals("https://www.amazon.com/"))
		{
			driver.navigate().to(amazonUrl);
			System.out.println("Redirect to amazon.in");
		}
		else
		{
			System.out.println("Successfully navigated to amazon.in");
		}
		
		//Step 2 - Click on the hamburger menu in the top left corner. 
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='hm-icon-label']")).click();
		Thread.sleep(3000);
		
		//Step 3 - Scroll down and then Click on the TV, Appliances and Electronics link under Shop by Department section.
		driver.findElement(By.xpath("//ul[16]//li[1]//a[1]"));
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//div[normalize-space()='TV, Appliances, Electronics']")).click();
		
		//Step 4 - Then click on Televisions under TV, Audio & Cameras sub section.
		driver.findElement( By.xpath("//a[normalize-space()='Televisions']")).click();
		
		//Step 5 - Scroll down and filter the results by Brand ‘SAMSUNG’.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2750)", "");
		driver.findElement(By.xpath("//*[@id=\"s-refinements\"]/div[20]/ul/li[2]/span/a")).click();
		
		//Step 6 - Sort the SAMSUNG results with price High to Low.
		Select drpCountry = new Select(driver.findElement(By.name("s")));
		drpCountry.selectByValue("price-desc-rank");
		
		//Step 7 - Click on the second highest priced item (whatever that maybe at the time of automating).
		js.executeScript("window.scrollBy(0,200)", "");
		driver.findElement(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//div[@class='a-section aok-relative s-image-square-aspect']")).click();
		
		//Step 8 - Switch the Window
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));

	    //Step 9 - Assert that “About this item” section is present and log this section text to console/report.
        js.executeScript("window.scrollBy(0, 1000)", "");
        WebElement webElement = driver.findElement(By.xpath("//h1[@class='a-size-base-plus a-text-bold']"));

        if(webElement.isDisplayed())
        {
            String a = webElement.getText();
        	//webElement.getText();
    	    Assert.assertEquals("About this item", a);
    	    System.out.println(a);
        }
	}
}