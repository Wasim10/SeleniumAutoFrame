package pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	//constructor
	public DashboardPage(WebDriver lDriver)
	{
	    this.driver = lDriver;
	    
	    PageFactory.initElements(driver, this);
	}

	 @FindBy(xpath = "//*[@id='login-list']/li[1]/a")
	    WebElement dashboardclick;

	    // @FindBy(xpath = "//*[@id='learn-press-user-profile']/ul/li[3]")
	    // WebElement offerAcademeis;
	    // ✅ New (CSS selector for "Offer Academies" tab)
    @FindBy(css = "li.border-radius-sm.academies_tab")
    WebElement offerAcademies;

	    @FindBy(xpath = "//*[@id='tab-academies']/div/div/ul/li[1]/form/div/button")
	    WebElement subscribeButton;

	    // public void dashboardClick() {
	    //     dashboardclick.click();
	    //     offerAcademeis.click();

	    //     // Scroll the subscribe button into view
	    //     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscribeButton);

	    //     // Optional short delay for scroll animation
	    //     try {
	    //         Thread.sleep(500);
	    //     } catch (InterruptedException e) {
	    //         Thread.currentThread().interrupt();
	    //     }

	    //     // Wait for the button to be clickable
	    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //     wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));

	    //     // Click the button
	    //     subscribeButton.click();
	    // }

public void dashboardClick() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    try {
        // Wait & click Dashboard
        wait.until(ExpectedConditions.elementToBeClickable(dashboardclick));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dashboardclick);

        // Wait for 'offerAcademeis' (instead of immediate .click())
        wait.until(ExpectedConditions.visibilityOf(offerAcademies));
    wait.until(ExpectedConditions.elementToBeClickable(offerAcademies));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", offerAcademies);

        // Scroll and click Subscribe
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscribeButton);
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton));
        subscribeButton.click();

    } catch (Exception e) {
        System.out.println("❌ Failed in dashboardClick: " + e.getMessage());
        throw e;
    }
}



}
