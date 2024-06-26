package LoginCred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonConstructor.commonConstructor;

public class Company extends commonConstructor {
	WebDriver driver;
	
	
	public Company(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}

	
	@FindBy(xpath="//p[contains(text(),'Kibbcom')]//parent::div//button[@class='company-select-card-bottom-btn']//child::span[contains(text(),' chevron_right ')]") 
	public WebElement company;
	
	public void companySelect() {
		company.click();
	}

}
