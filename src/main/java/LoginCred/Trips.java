package LoginCred;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CommonConstructor.commonConstructor;
import io.reactivex.rxjava3.functions.Action;

public class Trips  {
    WebDriver driver;

    public Trips(WebDriver driver) {
       
        this.driver = driver;
        PageFactory.initElements(driver, this);
        
    }

    @FindBy(xpath = "//div[@class='nav_list w-100 mb-auto']//child::a//child::span[contains(text(),'Trips')]//parent::a")
    private WebElement TripsLink;

    @FindBy(xpath = "//div[@id='tripsComponent']//following-sibling::div[@class='row my-4']//child::table[@id='_trips_content_table']//child::tbody//tr//td[contains(text(),'Trip 15532')]//parent::tr//descendant::span[@class='e-frame e-icons']")
    private WebElement checkbox;
    @FindBy(xpath="//div[@id='tripsComponent']//following-sibling::div[@class='row my-4']//child::table[@id='_trips_content_table']//child::tbody//tr//td[contains(text(),'Trip 15532')]//parent::tr//descendant::span[@class='e-frame e-icons e-check']")
    public WebElement check;
    @FindBy(xpath="//div[@class='e-content']") public WebElement insidescroll;

    public void Trip() {
        TripsLink.click();
    }

    public void FTrip() throws InterruptedException {
    	Thread.sleep(20000);
    	 
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	        try {
    	            wait.until(ExpectedConditions.elementToBeClickable(TripsLink));
    	            TripsLink.click();
    	            Actions action = new Actions(driver);
    	            action.moveToElement(insidescroll).build().perform();
    	            JavascriptExecutor js = (JavascriptExecutor) driver;
    	           // js.executeScript("window.scrollBy(0,2000)");
    	            //((JavascriptExecutor) driver).executeScript("arguments[0].scrollBy(0, 1000);", insidescroll);
    	            System.out.println("sroll");


    	            // Wait for the checkbox to be visible and clickable
    	            wait.until(ExpectedConditions.visibilityOf(checkbox));
    	            wait.until(ExpectedConditions.elementToBeClickable(checkbox));
    	            
    	          
    	            if (!checkbox.isSelected()) {
    	            	
    	                checkbox.click();
    	            }
                  SoftAssert  softAssert = new SoftAssert();
    	            // Assert that the checkbox is selected
    	            boolean isSelected = check.getAttribute("class").contains("e-check");
    	            softAssert.assertTrue(isSelected,"Checkbox is not selected.");
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	            Assert.fail("Failed to select the checkbox: " + e.getMessage());
            }
        }
    }

