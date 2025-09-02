package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {
	
	WebDriver driver;
	//constructor
	public LoginPage(WebDriver lDriver)
	{
		this.driver=lDriver;
		
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//*[@id=\"loginlabel\"]") WebElement loginclick;
	
	
@FindBy(name="log") WebElement uname;
	
	@FindBy(name="pwd") WebElement pass;
	
	@FindBy(name="wp-submit") WebElement loginButton;

	@FindBy(xpath="//*[@id=\"gk-login-toggle\"]/i") WebElement logoutimage;
	
	@FindBy(xpath="//*[@id=\"login_drop_panel\"]/div/ul/li[3]/a") WebElement logoutclick;



	
	// public void loginToPortal(String username, String password) {
	// 	// TODO Auto-generated method stub
	// 	loginclick.click();
	// 	uname.sendKeys(username);
	// 	pass.sendKeys(password);
	// 	loginButton.click();
		
	// }

	// updated one
public void loginToPortal(String username, String password) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
        wait.until(ExpectedConditions.elementToBeClickable(loginclick));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginclick);
    } catch (Exception e) {
        System.out.println("Fallback JS click for login: " + e.getMessage());
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginclick);
    }

    uname.sendKeys(username);
    pass.sendKeys(password);
    loginButton.click();
}


	
	public void logout() {
		logoutimage.click();
		logoutclick.click();
	}
}
