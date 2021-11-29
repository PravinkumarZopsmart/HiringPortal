package com.automate_hiring_port.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {
    private static final int waitSeconds = 5;
    private static final By numberOfApplications = By.cssSelector(".number-of-total-candidates-text");
    private static final By resumeScreeningCount = By.className("MuiBadge-badge MuiBadge-anchorOriginTopRightRectangle");

    public static int getNumberOfApplications(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(numberOfApplications));
        WebElement applications = driver.findElement(numberOfApplications);
        return Integer.parseInt(applications.getText());
    }

    public static int getNumberOfResumeScreening(WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitSeconds));
            wait.until(ExpectedConditions.visibilityOfElementLocated(resumeScreeningCount));
            return Integer.parseInt(driver.findElement(resumeScreeningCount).getText());
        } catch (Exception e) {
            return 0;
        }

    }
}
