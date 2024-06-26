package Login;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Base.Base;
import LoginCred.BrokenLinks;
import LoginCred.Company;
import LoginCred.LoginCred;
import LoginCred.Repo;
import LoginCred.Trips;

public class Login extends Base {
	WebDriver driver;
	
    
    @BeforeTest
    public void setUp() throws IOException {
        driver = browser(); // Initialize the driver using the browser method from Base class
    }

    @Test
    public void cred() {
        LoginCred cred = new LoginCred(driver); // Pass the properly initialized driver
        cred.logincred("akash.mahale@kibbcom.com");
        cred.pcode("Kibbcom12");
        cred.submit();
        
    }
    @Test(dependsOnMethods="cred")
    public void Selectcompany() {
    	Company company = new Company(driver);
    	 company.companySelect();
    	
    }
    @Test(dependsOnMethods="Selectcompany")
    public void Tripss() {
    	Trips tr = new Trips(driver);
    	tr.Trip();
    	
    }
    @Test(dependsOnMethods="Tripss")
    public void CheckBox() throws InterruptedException {
    	Trips tr = new Trips(driver);
    	tr.FTrip();
    	
    	
    }
    @Test(dependsOnMethods="CheckBox")
    public void log() {
    	Repo repo = new Repo(driver);
    	repo.repov();
    }
    @Test(dependsOnMethods="log") 
    public void openurl() throws Exception {
    	BrokenLinks link = new BrokenLinks(driver);
    	link.openLink();
    }
}
