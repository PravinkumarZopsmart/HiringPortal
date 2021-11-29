package com.automate_hiring_port.pages;

import com.automate_hiring_port.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Application extends BaseClass {
    private static final By pageHeadingLocator =By.cssSelector(".head-text-applications-list");
    private static final By tableContentsLocator = By.cssSelector(".MuiTableBody-root tr");

    public static String getPageHeading(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeadingLocator));
        return driver.findElement(pageHeadingLocator).getText();
    }

    public static int getNumberOfApplications(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(tableContentsLocator));
            return driver.findElements(tableContentsLocator).size();
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            return 0;
        }
    }
}
