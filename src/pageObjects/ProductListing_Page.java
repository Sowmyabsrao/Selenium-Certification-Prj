package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
 
public class ProductListing_Page extends BaseClass {
	private static WebElement element;
    public ProductListing_Page(WebDriver driver){
    	super(driver);
    	} 

	public static WebElement Select_product() {
		element = null;
       	try{
       		element= driver.findElement(By.xpath("//*[@id='no-results-phone-suggestion']/div/span"));
       		//element= driver.findElement(By.xpath("//*[text()=\"Selenium Certification Training\"]"));
       		Log.info("Selenium course is not found");
       		BaseClass.bResult = false;
       	}catch (Exception e){
       		Log.error("Selenium course is found");
       		
       		throw(e);
       		}
       	return element;
        }
	
	}
	 