package appModules;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

import pageObjects.BaseClass;
import pageObjects.Home_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;
     
    public class SignIn_Action  extends BaseClass {
    	
        
        public SignIn_Action(WebDriver driver){
            	super(driver);
        }    
        public static void Execute(int iTestCaseRow) throws Exception{
        	
        	// Clicking on the My Account link on the Home Page
        Log.info("Click action is perfromed on My Account link" );
        	
        	// Storing the UserName in to a String variable and Getting the UserName from Test Data Excel sheet
        	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
        	// Constant.Col_UserName is the column number for UserName column in the Test Data sheet
        driver.findElement(By.linkText("Log In")).click();
        try {
      		Thread.sleep(3000);
      	} catch (InterruptedException e) {
      		e.printStackTrace();
      	}

        
        	String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        	// Here we are sending the UserName string to the UserName Textbox on the LogIN Page
        	Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.id("si_popup_email")));
            actions.click();
            actions.sendKeys(sUserName);
            actions.build().perform();
            
            // Printing the logs for what we have just performed
            Log.info(sUserName+" is entered in UserName text box" );
            
            String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
            System.out.println(sPassword);
            actions.moveToElement(driver.findElement(By.id("si_popup_passwd")));
            actions.click();
            actions.sendKeys("12345678");
            actions.build().perform();
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='new_sign_up_mode']/div/div/div[2]/div[3]/form/button")));
            actions.click();
            actions.build().perform();
            Log.info("Click action is performed on Submit button");
            
            // Now it will wait 10 secs separately before jumping out to next step
            try {
          		Thread.sleep(1000);
          	} catch (InterruptedException e) {
          		e.printStackTrace();
          	}
            Utils.waitForElement(Home_Page.SearchBar());
            
            // This is another type of logging, with the help of TestNg Reporter log
            // This has to be very carefully used, you should only print the very important message in to this
            // This will populate the logs in the TestNG HTML reports
            Reporter.log("SignIn Action is successfully perfomred");
            
        }
    }
