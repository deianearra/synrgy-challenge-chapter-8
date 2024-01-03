package org.dei.pages;

import org.dei.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    public LoginPage(AppiumDriver driver) {
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[1]")
    private WebElement swaglabsLogo;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Login']/android.view.ViewGroup/android.widget.ImageView[2]")
    private WebElement swaglabsImage;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")
    private WebElement snackbarError;

    public void verifyComponentsOnLoginPage() {
        keyword.verifyElementExist(swaglabsLogo);
        keyword.verifyElementExist(inputUsername);
        keyword.verifyElementExist(inputPassword);
        keyword.verifyElementExist(loginButton);
        keyword.verifyElementExist(swaglabsImage);
        keyword.waitFor(2);
    }

    public void doLogin(String username, String password) {
        keyword.inputText(inputUsername, username);
        keyword.inputText(inputPassword, password);
    }

    public void tapLoginButton() {
        keyword.tapElement(loginButton);
        keyword.waitFor(2);
    }

    public void verifySnackbarErrorExist(String expectedMessage) {
        String actual = snackbarError.getText();
        Assert.assertEquals(actual, expectedMessage);
    }

}
