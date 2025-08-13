package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import utility.ReadExcelFile;

public class DashbaordTestCase extends BaseTest {

// test     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
	// https://github.com/Wasim10/Page-Object-Model---Automation-Framework-.git
	// Wasim10
	    String fileName = System.getProperty("user.dir") + "\\TestData\\TestPortalData.xlsx";

	    @Test(priority = 1)
	    void testcourses() {
	        LoginPage lp = new LoginPage(driver);
	        String username = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 0);
	        String password = ReadExcelFile.getCellValue(fileName, "LoginData", 1, 1);
	        lp.loginToPortal(username, password);

	        DashboardPage dp = new DashboardPage(driver);

	        dp.dashboardClick();
	    }
}
