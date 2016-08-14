package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_InvalidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"smoke"})
	public void testinvalidSearch(String TC_ID, String Order, String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID + " Order is  "+Order);
		Start_Server();
		Init_app();
		
		PageObject_Search BS_Pob=new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_btn,25);
		BS_Pob.Click_Searchbtn();
		
		
		Explicit_wait(BS_Pob.Search_txt,25);
		BS_Pob.Enter_Searchitem(Search_Item);
		
		
		Explicit_wait(BS_Pob.Invalid_Searchmsg,25);
		String Actual_result = BS_Pob.getInvalidmsg();
		
		//validate
		if(Actual_result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is " +Actual_result+ " Expected Result is " +Exp_Result);
			Snapshot1(TC_ID, Order);
		}
		else
		{
			
			log.info("Failed as Actual Result is " +Actual_result+ " Expected Result is " +Exp_Result);
			sAssert.fail("Failed as Actual Result is " +Actual_result+ " Expected Result is " +Exp_Result);
			Snapshot1(TC_ID, Order);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
		
	}
	
	
	//Valid search
	
	@Test(dataProvider="dp_ValidSearch", dataProviderClass=DataProvider_Component.DataProvider_Search.class,groups={"regressioon"})
	public void testValidSearch(String TC_ID, String Order, String Search_Item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID + " Order is  "+Order);
		
		Start_Server();
		Init_app();
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_btn, 25);
		BS_Pob.Click_Searchbtn();
		
		
		Explicit_wait(BS_Pob.Search_txt,25);
		BS_Pob.Enter_Searchitem(Search_Item);
		
		
		Explicit_wait(BS_Pob.Valid_Searchmsg,25);
		String Output = BS_Pob.getValidCount();
		
		String Actual_Result = Output.replace(" products", "");
		
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual Result is " +Actual_Result+ " Expected Result is " +Exp_Result);
		}
		else
		{
			log.info("Failed as Actual Result is " +Actual_Result+ " Expected Result is " +Exp_Result);
			sAssert.fail("Failed as Actual Result is " +Actual_Result+ " Expected Result is " +Exp_Result);
		}
		
		Stop_Server();
		sAssert.assertAll();
	}
	
	
	
	
	
	
	
	
	
	

}
