package com.automate_hiring_port;

import com.automate_hiring_port.base.BaseClass;
import com.automate_hiring_port.pages.Application;
import com.automate_hiring_port.pages.Dashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestApplication {

    private WebDriver driver;
    private final String emailID = "pravin.kumar@zopsmart.com";
    private final String password = "Godofwar@25";
    private final String URL = "https://stage.hiringmotion.com/login";

    @BeforeSuite
    public void driverSetup() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/WebDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
    }

    @BeforeClass
    public void login() throws InterruptedException {
        driver.get(URL);
        BaseClass.loginToHiringMotion(driver,emailID,password);
    }

    @Test
    public void testTitle() {
        assertEquals(BaseClass.getTitle(driver),"Hiring Motion");
    }

    @Test(dependsOnMethods = {"testTitle"})
    public void testPageHeading() {
        BaseClass.selectSideBarPage(driver,"applications");
        assertEquals(Application.getPageHeading(driver),"Applications");
    }

    @Test(dependsOnMethods = {"testPageHeading"})
    public void testApplicationsAndDashboard() {
        int expectedNumberOfApplications = Application.getNumberOfApplications(driver);
        BaseClass.selectSideBarPage(driver,"Dashboard");
        int actualNumberOfApplications = Dashboard.getNumberOfApplications(driver);
        assertEquals(actualNumberOfApplications,expectedNumberOfApplications);
    }
}
