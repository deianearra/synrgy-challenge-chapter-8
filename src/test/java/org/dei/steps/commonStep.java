package org.dei.steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.dei.factories.driverManager;
import org.dei.helpers.keyword;
import org.dei.pages.HomePage;
import org.dei.pages.LoginPage;

public class commonStep {

    private final LoginPage loginPage;
    private final HomePage homePage;

    public commonStep() {
        AndroidDriver androidDriver = driverManager.getInstance().getDriver();
        loginPage = new LoginPage(androidDriver);
        homePage = new HomePage(androidDriver);
    }

    @Given("user is already on home page")
    public void userIsAlreadyOnHomePage() {
        loginPage.verifyComponentsOnLoginPage();
        loginPage.doLogin("standard_user", "secret_sauce");
        loginPage.tapLoginButton();
        homePage.verify_Component_OnHomePage("PRODUCTS");
    }

    @Given("user open SwagLabs app")
    public void userOpenSwagLabsApp() {
        loginPage.verifyComponentsOnLoginPage();
    }

    @And("user take screenshot {string}")
    public void userTakeScreenshot(String screenshot) {
        keyword.takeScreenshot(screenshot);
    }
}
