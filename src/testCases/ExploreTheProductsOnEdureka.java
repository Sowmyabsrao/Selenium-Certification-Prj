package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import pageObjects.ProductListing_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
import appModules.CheckOut_Action;
import appModules.SignIn_Action;

public class ExploreTheProductsOnEdureka{
	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	
  //  before method is your prerequisites of your main Test Case	
  @BeforeMethod
  public void beforeMethod() throws Exception {
	    // Configuring Log4j logs, please see the following posts to learn about Log4j Logging
	  	DOMConfigurator.configure("log4j.xml");
	  	
	  	// Getting the Test Case name, as it will going to use in so many places
	  	// The main use is to get the TestCase row from the Test Data Excel sheet
	  	sTestCaseName = this.toString();
	  	// From above method we get long test case name including package and class name etc.
	  	// The below method will refine your test case name, exactly the name use have used
	  	sTestCaseName = Utils.getTestCaseName(this.toString());
	  	
	  	
	  	// Start printing the logs and printing the Test Case name
		Log.startTestCase(sTestCaseName);
		
		// Setting up the Test Data Excel file using Constants variables
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		// Fetching the Test Case row number from the Test Data Sheet
		// This row number will be feed to so many functions, to get the relevant data from the Test Data sheet 
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		// Launching the browser, this will take the Browser Type from Test Data Sheet 
		driver = Utils.OpenBrowser(iTestCaseRow);
		
		// Initializing the Base Class for Selenium driver
		new BaseClass(driver);  
        }
  
  // This is the starting of the Main Test Case
  @Test
  public void main() throws Exception {
	  try{
		 
		SignIn_Action.Execute(iTestCaseRow);
		Home_Page.SearchBar().sendKeys(ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Course));
		Home_Page.SearchBar().sendKeys(Keys.ENTER);
		Log.info("Searching for the course");
		Utils.waitForElement(Home_Page.SeleniumCourse());
		Thread.sleep(2000);
		
		WebElement usernameField = driver.findElement(By.xpath("//*[@id='d_wishlist-icon-535']"));
		usernameField.click();
		Thread.sleep(2000);
		/*String Search = usernameField.getAttribute("data-original-title");
		
		System.out.println(Search);
		if(Search.contains("Add to wishlist")){
			usernameField.click();
	    }*/
		
		driver.findElement(By.xpath("//*[@id=\'header-II\']/section/nav/div[1]/ul[2]/li[1]/a/span")).click();
		driver.findElement(By.xpath("//*[@href=\'https://www.edureka.co/search/favourite\']")).click();
		Thread.sleep(2000);
		ProductListing_Page.Select_product().click();	
		
		// This is to check that if any of your verification during the execution is failed
		if(BaseClass.bResult==true){
			// If the value of boolean variable is True, then your test is complete pass and do this
			Utils.waitForElement(Home_Page.EnrollButton());
			Home_Page.EnrollButton().click();
			Thread.sleep(2000);
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");

			CheckOut_Action.Execute();
			
			ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
		}else{
			// If the value of boolean variable is False, then your test is fail, and you like to report it accordingly
			// This is to throw exception in case of fail test, this exception will be caught by catch block below
			throw new Exception("Test Case Failed because of Verification");
		}
		
	  // Below are the steps you may like to perform in case of failed test or any exception faced before ending your test 
	  }catch (Exception e){
		  // If in case you got any exception during the test, it will mark your test as Fail in the test result sheet
		  ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
		  Utils.takeScreenshot(driver, sTestCaseName);
		  Log.error(e.getMessage());
		  // Again throwing the exception to fail the test completely in the TestNG results
		  throw (e);
	  }
		
  }
		
  // Its time to close the finish the test case		
  @AfterMethod
  public void afterMethod() {
	    // Printing beautiful logs to end the test case
	    Log.endTestCase(sTestCaseName);
	    // Closing the opened driver
	    driver.close();
  		}

}
