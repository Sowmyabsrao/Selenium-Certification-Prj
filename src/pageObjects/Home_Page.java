package pageObjects;
        import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Log;
    public class Home_Page extends BaseClass{
            private static WebElement element = null;
           
        public Home_Page(WebDriver driver){
            	super(driver);
        }    
        
        
        public static WebElement SearchBar() throws Exception{
            try{ 
	        	 element = driver.findElement(By.xpath(".//*[@id='search-inp']"));
	             Log.info("Search Button is found");
            }catch (Exception e){
           		Log.error("Search Button is not found");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement SeleniumCourse() throws Exception{
            try{ 
	        	 element = driver.findElement(By.className("bestseller"));
	             Log.info("Selenium course is found");
            }catch (Exception e){
           		Log.error("Selenium course is not found");
           		throw(e);
           		}
           	return element;
        }
        
        public static WebElement EnrollButton() throws Exception{
        	
        	try{ 
	        	 element = driver.findElement(By.xpath("//*[@id=\"Batches\"]/div/div[2]/div[2]/a/button"));
	             Log.info("Enroll button is found");
           }catch (Exception e){
          		Log.error("Enroll button is not found");
          		throw(e);
          		}
          	return element;
        }
        
      
    }
