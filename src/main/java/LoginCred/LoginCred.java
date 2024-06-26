package LoginCred;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

public class LoginCred {
    WebDriver driver;
    
    @FindBy(id = "textbox_0")
    public WebElement login;
    @FindBy(id = "textbox_1")
    public WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    public WebElement button;

    public LoginCred(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
    public void logincred(String user) {
        login.sendKeys(user);
    }
    public void pcode(String code) {
        password.sendKeys(code);
    }
    public void submit() {
    	button.click();
        
    }
}
