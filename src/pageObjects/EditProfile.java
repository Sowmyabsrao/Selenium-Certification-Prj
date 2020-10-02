package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
public class EditProfile extends BaseClass {
	private static WebElement element;
	public EditProfile(WebDriver driver) {
		
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static WebElement navigate_to_my_profile(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//*[@id=\"header-II\"]/section/nav/div[1]/ul[2]/li[1]/a"));
	      		Log.info("Navigate to my profile button is found on the Home Page");
	      	}catch (Exception e){
	      		Log.error("Continue button on Home page is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	public static WebElement my_profile(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//*[@href=\"https://learning.edureka.co/my-profile\"]"));
	      		Log.info("Navigate to my profile button is found on the Home Page");
	      	}catch (Exception e){
	      		Log.error("Continue button on Home page is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	
	public static WebElement my_profile_button(){
	   	 element = null;
	      	try{
	      		//element= driver.findElement(By.xpath("//*[@id=\"myprofile\"]/div[2]/div[1]/div/div[1]/h4[2]/span/i"));
	      		element= driver.findElement(By.linkText("My Profile"));
	      		Log.info("Navigate to my profile button is found on the Home Page");
	      	}catch (Exception e){
	      		Log.error("Continue button on Home page is not found");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	
	
	public static WebElement professional_experience(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.className("icon-pr-edit"));
	      		Log.info("professional experience dropdown button is found on the Edit profile");
	      	}catch (Exception e){
	      		Log.error("professional experience dropdown button is not found on the Edit profile");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	public static WebElement current_industry(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//*[contains(@name,'currentIndustry')]"));
	      		Log.info("current industry dropdown button is found on the Edit profile");
	      	}catch (Exception e){
	      		Log.error("current industry dropdown button is  notfound on the Edit profile");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	public static WebElement current_job(){
	   	 element = null;
	      	try{
	      		element= driver.findElement(By.xpath("//*[contains(@name,'currentjob')]"));
	      		Log.info("current job dropdown button is found on the Edit profile");
	      	}catch (Exception e){
	      		Log.error("current job dropdown button is not found on the Edit profile");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	
	public static WebElement employement_type(){
	   	 element = null;
	      	try{
	      		element = driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[7]//select"));
	      		Log.info("emplyement Type dropdown button is found on the Edit profile");
	      	}catch (Exception e){
	      		Log.error("emplyement Type dropdown button is not found on the Edit profile");
	      		throw(e);
	      		}
	      	return element;
	       }
	
	public static WebElement ctc(){
	   	 element = null;
	      	try{
	      		element = driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[2]//select"));
	      		Log.info("ctc dropdown button is found on the Edit profile");
	      	}catch (Exception e){
	      		Log.error("ctc dropdown button is not found on the Edit profile");
	      		throw(e);
	      		}
	      	return element;
	       }
	public static WebElement edit_profile(){
   	 element = null;
      	try{
      		element= driver.findElement(By.xpath("//*[@id=\"cddccard\"]/div[2]/button"));
      		Log.info("Continue button is found on the Check Out Page");
      	}catch (Exception e){
      		Log.error("Continue button on Check Out page is not found");
      		throw(e);
      		}
      	return element;
       }

}
