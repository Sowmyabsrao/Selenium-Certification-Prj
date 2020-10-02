package appModules;

import pageObjects.ProductListing_Page;

public class CourseSelectAction {
	
	public static void Execute() throws Exception{
		 
		// This is to select the product from the list
     	ProductListing_Page.Select_product().click();

}
}
