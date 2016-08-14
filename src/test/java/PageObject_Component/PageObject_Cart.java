package PageObject_Component;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class PageObject_Cart {
	
	public AppiumDriver driver;
	
	

	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Search_btn;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Search_txt;
	
	@FindBy(xpath="//*[@resource-id='com.bigbasket.mobileapp:id/imgAddToBasket']")
	public WebElement Add_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnViewBasket")
	public WebElement Cart_Img;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement AddCart_msg;
	
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Delete_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_msg;
	
	
	public PageObject_Cart(AppiumDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Searchbtn()
	{
		Search_btn.click();
	}
	
	public void Enter_Searchitem(String Value)
	{
		
		Search_txt.sendKeys(Value +"\n");
		
	}
	
	public void Click_Addbtn()
	{
		Add_btn.click();
		
	}

	
	public void Click_Cartimg()
	{
		Cart_Img.click();
		
	}
	
	public String getAddCartmsg()
	{
		return AddCart_msg.getText();
	}
	
	public void Click_Deletbtn()
	{
		Delete_btn.click();
		
	}
	
	public String getDeleteCartmsg()
	{
		return Delete_msg.getText();
	}
	
}
