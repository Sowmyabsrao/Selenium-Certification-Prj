package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BaseClass;
import pageObjects.EditProfile;
import utility.Log;

public class EditProfile_Action extends BaseClass {
	
	public EditProfile_Action(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		// iTestcaseRow is the row number of our Testcase name in the Test Data sheet
		// iTestcaseRow is passed as an Argument to this method, so that it can used inside this method
		public static void execute() throws Exception{
			try{
				
				EditProfile.navigate_to_my_profile().click();
				Log.info("Navgating to my profile page");
				EditProfile.my_profile().click();
				Log.info("CLick on edit profile page");
				WebDriverWait waitElement = new WebDriverWait(driver,20);
				waitElement.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("icon-pr-edit")));
				EditProfile.my_profile_button().click();
				Thread.sleep(1000);
				//Select dropdown=new Select(EditProfile.professional_experience());
				//dropdown.selectByIndex(2);
				//Log.info("Selected the professional experience from the dropdown menu");
				Select dropdown1=new Select(EditProfile.current_industry());
				dropdown1.selectByIndex(2);
				Log.info("Selected the current industry from the dropdown menu");
				Select dropdownCurrentJob=new Select(EditProfile.current_job());
				dropdownCurrentJob.selectByIndex(2);
				//Select dropdownEmployementType = new Select(EditProfile.employement_type());
				//dropdownEmployementType.selectByIndex(2);
				//Select dropdownCTC = new Select(EditProfile.ctc());
				//dropdownCTC.selectByIndex(2);
				driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[4]/div/div/div/div/div/div[2]/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[4]/div/div/div/div/div/div[2]/input")).sendKeys("Bengaluru");
				driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[1]/div/div/div/div[6]/div/div/div/div/label[2]/span")).click();
				driver.findElement(By.xpath("//*[@id=\"professional_detail\"]/app-professional-detail/div[1]/div/form/div[2]/div/div[1]/button")).click();

			}catch(Exception e){
				throw(e);
				}

		}
}
