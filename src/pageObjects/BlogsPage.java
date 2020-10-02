package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Log;

public class BlogsPage extends BaseClass {
	private static WebElement element, element1;
	public BlogsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	public static WebElement Blog_button() {
		element = null; element1 = null;
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,9000)");

       	try{
       		//WebDriverWait waitElement = new WebDriverWait(driver,30);
       	//	waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='footauto']/app-root/app-mycourse-main/app-footer/footer/div/div/div/div[1]/div[1]/ul/li[4]/a")));
       		
       		driver.findElement(By.xpath("//*[contains(@text,'Blog')]")).click();
       		Log.info("Blog button is found");
       	}catch (Exception e){
       		Log.error("Blog button is not found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	
	
	public static WebElement search_blog() {
		element = null;
       	try{
       		element= driver.findElement(By.id("search-inp"));
       		Log.info("Search button is found");
       	}catch (Exception e){
       		Log.error("Search button is not found");
       		
       		throw(e);
       		}
       	return element;
        }

}
