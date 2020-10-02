package appModules;

import org.testng.Reporter;

import pageObjects.PaymentDetails_Page;
import utility.Log;

public class PaymentDetails_Action {
	
	// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
	// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
	public static void execute(int iTestCaseRow) throws Exception{
		try{
  			
			// Clearing the pre-populated details on this field
			PaymentDetails_Page.txt_ZipCode().clear();
   			PaymentDetails_Page.txt_ZipCode().sendKeys("560092");			
			
			PaymentDetails_Page.txt_State().clear();
			PaymentDetails_Page.txt_State().sendKeys("Karnataka");
			Log.info(" State is entered on the Payment detail page");
			
			PaymentDetails_Page.txt_Address().clear();
			PaymentDetails_Page.txt_Address().sendKeys("Bangalore");
			Log.info( "Address is entered on the Payment detail page");
		
			
			PaymentDetails_Page.txt_City().clear();
			PaymentDetails_Page.txt_City().sendKeys("Bangalore");
			Log.info("City is entered on the Payment detail page");
			
			PaymentDetails_Page.drpdwn_Country("India");
			Log.info(" Country is Selected on the Payment detail page");
			
		
			PaymentDetails_Page.scroll();
			// Clicking on the Cancel button to cancel the payment
			PaymentDetails_Page.btn_Cancel().click();
			Log.info("Click action is performed on cancel button on the Payment detail page");
			
            
			Reporter.log("Payment is cancelled for the product.");
			
	    }catch(Exception e){
			throw(e);
			}
		}
}
