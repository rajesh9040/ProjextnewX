package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    protected WebDriver driver;

    public Base() {
        // Default constructor
    }

    public WebDriver browser() throws IOException {
        Properties prop = new Properties();
        FileInputStream input = null;

        try {
            input = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/GlobalProperties/Global.properties");
            prop.load(input);
            String browserName = prop.getProperty("browse");

            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\91700\\eclipse-workspace\\Projectx\\drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.navigate().to("https://stage.app.vialumina.eu/");
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            }

        } finally {
            if (input != null) {
                input.close();
            }
        }

        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
    
  
    
    
}
