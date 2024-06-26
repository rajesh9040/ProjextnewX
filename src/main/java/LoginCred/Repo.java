package LoginCred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import CommonConstructor.commonConstructor;

public class Repo extends commonConstructor {
	
	WebDriver driver;

	public Repo(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	
	}
	@FindBy(xpath="//span[contains(text(),'Reports')]//parent::a[@href='#/reports']") 
	public WebElement  ReportV;
	
	public void repov() {
		ReportV.click();
	}

}
