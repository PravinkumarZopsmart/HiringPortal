package com.automate_hiring_port.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseClass {
    private static final By loginButtonLocator = By.cssSelector("#root > div > main > div:nth-child(2) > div > div > button");
    private static final By emailInputLocator = By.id("identifierId");
    private static final By passwordInputLocator = By.cssSelector("#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input");
    private static final By passwordButtonLocator = By.cssSelector("#passwordNext > div > button > span");
    private static final By emailNextButtonLocator = By.cssSelector("#identifierNext > div > button > span");
    private static final By sideBarButtonLocator = By.cssSelector(".side-bar-buttons a");

    public static void loginToHiringMotion(WebDriver driver, String emailID, String password) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        Thread.sleep(7000);
        driver.findElement(loginButtonLocator).click();
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        driver.findElement(emailInputLocator).sendKeys(emailID);
        driver.findElement(emailNextButtonLocator).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInputLocator));
        driver.findElement(passwordInputLocator).sendKeys(password);
        driver.findElement(passwordButtonLocator).click();
        String title = driver.switchTo().window(windows.get(0)).getTitle();
        System.out.println(title);
    }

    public static String getTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public static void selectSideBarPage(WebDriver driver, String button) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sideBarButtonLocator));
        List<WebElement> sideButtons = driver.findElements(sideBarButtonLocator);
        for (WebElement sideButton : sideButtons) {
            if (sideButton.getText().equalsIgnoreCase(button)) {
                sideButton.click();
                break;
            }
        }
    }
}
