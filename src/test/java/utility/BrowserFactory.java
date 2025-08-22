/*
old working code
package utility; import java.time.Duration; import java.util.concurrent.TimeUnit; import org.openqa.selenium.WebDriver; import org.openqa.selenium.chrome.ChromeDriver; import org.openqa.selenium.chrome.ChromeOptions; import org.openqa.selenium.firefox.FirefoxDriver; import org.openqa.selenium.ie.InternetExplorerDriver; public class BrowserFactory { public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl) { if(browserName.equals("Chrome")) { System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe"); ChromeOptions op = new ChromeOptions(); op.addArguments("--remote-allow-origins=*"); driver = new ChromeDriver(op); } else if(browserName.equals("Firefox")) { System.setProperty("webdriver.chrome.driver", "./Drivers/geckodriver.exe"); driver = new FirefoxDriver(); } else if(browserName.equals("IE")) { System.setProperty("webdriver.chrome.driver", "./Drivers/IEDriverServer.exe"); driver = new InternetExplorerDriver(); } else { System.out.println("We do not support this browser "); } driver.manage().window().maximize(); driver.get(appUrl); driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); return driver; } public static void quitBrowser(WebDriver driver) { driver.quit(); } }
*/
package utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl) {

        if (browserName.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions op = new ChromeOptions();
            op.addArguments("--remote-allow-origins=*");
            op.addArguments("--headless=new");       // ✅ Important for Jenkins/EC2 (no display)
            op.addArguments("--no-sandbox");
            op.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(op);

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        } else {
            System.out.println("❌ Browser not supported: " + browserName);
        }

        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }
}
