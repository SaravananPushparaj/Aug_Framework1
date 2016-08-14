package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<String[]> getAddCartdata() throws IOException
	{
		
		List<String[]> Obj = flagrowCount("AddCart");
		return Obj.iterator();
		
	}
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<String[]> getDeleteCartdata() throws IOException
	{
		
		List<String[]> Obj = flagrowCount("DeleteCart");
		return Obj.iterator();
		
	}
	
	
	public static List<String[]> flagrowCount(String scriptname) throws IOException	
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\July_BB_Project\\TestData\\Test_Data.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int RowCount = xl.getrowcount(Scenario_Cart);
		
		//create the list
		
		List<String[]> List_cart=new ArrayList<String[]>();
		
		for(int xlRow=1;xlRow<=RowCount;xlRow++)
		{
			String Execute_Flag = xl.Readvalue(Scenario_Cart, xlRow, "Execute_Flag");
			String Script_name = xl.Readvalue(Scenario_Cart, xlRow, "Script_name");
			
			if((Execute_Flag.equals("Y")) && (Script_name.equals(scriptname)))
			{
				
				String[] arr_cart= new String[5];
				
				arr_cart[0]=xl.Readvalue(Scenario_Cart, xlRow, "TC_ID");
				arr_cart[1]=xl.Readvalue(Scenario_Cart, xlRow, "Order");
				arr_cart[2]=xl.Readvalue(Scenario_Cart, xlRow, "Search_Item");
				arr_cart[3]=xl.Readvalue(Scenario_Cart, xlRow, "Quantity");
				arr_cart[4]=xl.Readvalue(Scenario_Cart, xlRow, "Exp_Result");
				
				List_cart.add(arr_cart);
				
				
			}//end of if
			
		}//end of for
		
		return List_cart;
		
	}
	

}
