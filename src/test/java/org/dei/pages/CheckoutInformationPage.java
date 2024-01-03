package org.dei.pages;

import org.dei.helpers.keyword;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class CheckoutInformationPage {

    protected AppiumDriver appiumDriver;

    public CheckoutInformationPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Menu']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement burgerNav_icon;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")
    private WebElement swagLabs_icon;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement cart_icon;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")
    private WebElement top_greyBox;

    @FindBy(xpath = "//android.widget.ScrollView[@content-desc='test-Checkout: Your Info']/android.view.ViewGroup/android.view.ViewGroup[8]")
    private WebElement bottom_greyBox;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
    private WebElement input_firstName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
    private WebElement input_lastName;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
    private WebElement input_postalCode;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CANCEL']")
    private WebElement cancel_button;

    @FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
    private WebElement continue_button;

    public void verify_Component_OnCheckoutInformation () {
        keyword.verifyElementExist(burgerNav_icon);
        keyword.verifyElementExist(swagLabs_icon);
        keyword.verifyElementExist(cart_icon);
        keyword.verifyElementExist(top_greyBox);
        keyword.verifyElementExist(bottom_greyBox);
        keyword.verifyElementExist(input_firstName);
        keyword.verifyElementExist(input_lastName);
        keyword.verifyElementExist(input_postalCode);
        keyword.verifyElementExist(continue_button);
        keyword.verifyElementExist(cancel_button);
    }

    public void fill_checkoutInformation(String firstName, String lastName, String postalCode) {
        keyword.inputText(input_firstName, firstName);
        keyword.inputText(input_lastName, lastName);
        keyword.inputText(input_postalCode, postalCode);
        keyword.tapElement(continue_button);
        keyword.waitFor(3);
    }

}
