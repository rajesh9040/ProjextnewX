package LoginCred;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

import CommonConstructor.commonConstructor;

public class BrokenLinks  {
	WebDriver driver;
	public  BrokenLinks(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	
		}
	
	public void openLink() throws Exception, IOException   {
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> listlink = driver.findElements(By.tagName("a"));
		for(WebElement ulink:listlink) {
			String lnk = ulink.getAttribute("href");
			if (lnk == null || lnk.isEmpty()) {
	            System.out.println("URL is null or empty. Skipping...");
			}
			try {
			HttpURLConnection connection = (HttpURLConnection) new URL(lnk).openConnection();
			connection.connect();
			int response = connection.getResponseCode();
			if(response>=400) {
				System.out.println("Broken link:"+lnk);
			}
			else {
				System.out.println(lnk);
			}
		}
			 catch (MalformedURLException e) {
	                System.out.println("Malformed URL: " + lnk);
	            } catch (IOException e) {
	                System.out.println("IOException for URL: " + lnk);
	            }
		}
		
		
	}
	
	
}
