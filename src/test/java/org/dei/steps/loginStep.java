package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.shidqiadiatma.pages.HomePage;
import com.shidqiadiatma.pages.LoginPage;

public class loginStep {

    private final LoginPage loginPage;
    private final HomePage homePage;

    public loginStep() {
        AndroidDriver androidDriver = driverManager.getInstance().getDriver();
        loginPage = new LoginPage(androidDriver);
        homePage = new HomePage(androidDriver);
    }

    @When("user login using {string}")
    public void loginAs(String credentialType) {
        String username;
        String password;

        switch (credentialType) {
            case "standard_user" -> {
                username = "standard_user";
                password = "secret_sauce";
            }
            case "locked_out_user" -> {
                username = "locked_out_user";
                password = "secret_sauce";
            }
            default -> throw new RuntimeException("Credential type doesn't exist");
        }

        loginPage.doLogin(username, password);
        loginPage.tapLoginButton();
    }

    @Then("user direct to dashboard screen")
    public void userDirectToDashboardScreen() {
        homePage.verify_Component_OnHomePage("PRODUCTS");
    }

    @Then("user verify snackbar error with value {string} exists")
    public void userVerifySnackbarError(String value) {
        loginPage.verifySnackbarErrorExist(value);
    }

}
