package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage {

	WebDriver driver;
	
	 public AccountRegistrationPage(WebDriver driver)
  
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	
	@FindBy(id="input-password")
	WebElement txtPassword;
	
	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(name="agree")
	WebElement chbxAgree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement Btncontinue;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement MsgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
		
	}
	
	public void setLastName(String lname)
	{
		
		txtLastName.sendKeys(lname);
		
	}
	
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	} 
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
		
	}
	
	public void setPassword(String pwd)
	{
		
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String Confmpwd)
	{
		txtConfirmPassword.sendKeys(Confmpwd);
	}
	
	public void setPrivacyPolicy() 
	{
		chbxAgree.click();
		
	}
	public void clickContinue()
	{
		Btncontinue.click();
		
	}
	
	public String getConfirmationMsg()
	{
		try
		{
			
			return(MsgConfirmation.getText());
		}
		
		catch(Exception e)
		{
			
			return(e.getMessage());
			
		}
		
		
		
	}
	
	
	}
	
	
	

