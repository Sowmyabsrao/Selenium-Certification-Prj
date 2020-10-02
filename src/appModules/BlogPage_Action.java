package appModules;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;
import pageObjects.BlogsPage;


public class BlogPage_Action extends BaseClass {
	private static WebElement element;
	
public BlogPage_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

public static void Execute() throws Exception{ 
     	
	BlogsPage.Blog_button().click();
	WebDriverWait waitElement = new WebDriverWait(driver,30);
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	//Use the list of window handles to switch between windows
	String handleName = tabs.get(0);
    driver.switchTo().window(handleName);
    //Search for edureka selenium blogs
    
    BlogsPage.search_blog().sendKeys("selenium");
    BlogsPage.search_blog().sendKeys(Keys.ENTER);
    waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='searchresults']")));
    String Search = driver.findElement(By.id("search-tag-name")).getText();
    System.out.println(Search);
    if(Search.equals("selenium")) {
    	System.out.println("The search is filtered for selenium");
    }
    Thread.sleep(2000);
    //Get the interview questions blog
    driver.findElement(By.xpath("//*[text()='Interview Questions']")).click();
    waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Interview Questions']")));
    Thread.sleep(2000);
    driver.getPageSource().contains("Top Selenium Interview Questions And Answers You Must Prepare In 2018");
    System.out.println(driver.getTitle());
    String originalHandle = tabs.get(1);
    driver.switchTo().window(originalHandle);
    String Pagetitle = driver.getTitle();
    System.out.println(Pagetitle);
	 }


}
