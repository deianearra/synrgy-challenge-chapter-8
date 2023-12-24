package com.shidqiadiatma.pages;

import com.shidqiadiatma.helpers.enums.direction;
import com.shidqiadiatma.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class YourCartPage {

    protected AppiumDriver appiumDriver;

    public YourCartPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
    private WebElement checkout_button;

    public void tap_checkoutButton() {
        keyword.swipe(direction.UP); //scroll down
        keyword.waitFor(3);
        keyword.waitUntilElementIsClickable(checkout_button);
        keyword.tapElement(checkout_button);

    }

}
