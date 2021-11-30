package com.automate_hiring_port.pages;

import com.automate_hiring_port.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Application extends BaseClass {
    private static final By pageHeadingLocator =By.cssSelector(".head-text-applications-list");
    private static final By tableContentsLocator = By.cssSelector(".MuiTableBody-root tr");
    private static final By nextPageButtonLocator = By.cssSelector(".MuiTablePagination-actions button:nth-child(2)");
    private static final By previousPageButtonLocator = By.cssSelector("MuiTablePagination-actions button:nth-child(1)");
    private static final By numberOfApplications = By.cssSelector("MuiToolbar-root" +
            ".MuiToolbar-regular.MuiTablePagination-toolbar.MuiToolbar-gutters p");

    public static String getPageHeading(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeadingLocator));
        return driver.findElement(pageHeadingLocator).getText();
    }

    public static int getNumberOfApplicationsInCurrentPage(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(tableContentsLocator));
            return driver.findElements(tableContentsLocator).size();
        } catch (Exception e) {
            System.out.println(e.getClass().getName());
            return 0;
        }
    }

    public static void moveToNextPage(WebDriver driver) {
        WebElement nextPageButton = driver.findElement(nextPageButtonLocator);
        if(nextPageButton.isEnabled()) {
            nextPageButton.click();
        }
    }

    public static void moveToPreviousPage(WebDriver driver){
        WebElement previousPageButton = driver.findElement(previousPageButtonLocator);
        if(previousPageButton.isEnabled()){
            previousPageButton.click();
        }
    }

    public static int getNumberOfApplications(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfApplications));
        String applicationsCount = driver.findElement(numberOfApplications).getText();
        String[] countArray = applicationsCount.split(" ");
        return Integer.parseInt(countArray[2]);
    }
}
