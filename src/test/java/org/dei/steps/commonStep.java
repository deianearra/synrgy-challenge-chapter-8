package com.shidqiadiatma.steps;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.helpers.keyword;
import com.shidqiadiatma.pages.HomePage;
import com.shidqiadiatma.pages.LoginPage;

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
