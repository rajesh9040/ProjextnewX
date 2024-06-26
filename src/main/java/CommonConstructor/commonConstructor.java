package CommonConstructor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class commonConstructor {
	
	WebDriver driver;
	public commonConstructor(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
	

}
