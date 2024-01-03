package org.dei.helpers;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.dei.factories.driverManager;
import org.dei.helpers.enums.direction;
import org.dei.helpers.enums.fileType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class keyword {

    private static final AppiumDriver driver = driverManager.getInstance().getDriver();

    private static final Duration WAIT_DURATION = Duration.ofSeconds(20);

    private static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(driver, WAIT_DURATION);
    }

    public static void waitFor(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void inputText(WebElement element, String value) {
        waitUntilElementIsVisible(element);
        element.clear();
        element.sendKeys(value);
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void verifyElementExist(WebElement element) {
        element.isDisplayed();
    }

    public static void verifyWordingOnElement(WebElement element, String expectedText) {
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void tapElement(WebElement element) {
        waitUntilElementIsClickable(element);
        element.click();
    }

    public static void getText(WebElement element, String expectedNumber) {
        waitUntilElementIsClickable(element);
        element.getText();
    }

    private static void swipe(Point source, Point target) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), source.getX(), source.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), target.getX(), target.getY()));
        driver.perform(Collections.singleton(swipe));
    }

    public static void swipe(direction Direction) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        int startX = width / 2, startY = 0, endX = width / 2, endY = 0;

        if (Direction.equals(direction.UP)) {
            startY = (int) (height * 0.2);
            endY = (int) (height * 0.8);
        } else if (Direction.equals(direction.DOWN)) {
            startY = (int) (height * 0.8);
            endY = (int) (height * 0.2);
        }

        Point start = new Point(startX, startY);
        Point end = new Point(endX, endY);

        swipe(end, start);
    }

    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot screenshot = ((TakesScreenshot) driverManager.getInstance().getDriver());
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File("reports/screenshots" + File.separator + fileName + "." + fileType.PNG.name());

            FileUtils.copyFile(sourceFile, destinationFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

