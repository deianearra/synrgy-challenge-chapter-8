package com.shidqiadiatma.steps;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sortingStep {

    private final AndroidDriver androidDriver;
    private final HomePage homePage;

    public sortingStep() {
        androidDriver = driverManager.getInstance().getDriver();
        homePage = new HomePage(androidDriver);
    }

    @When("user select filter price high to low")
    public void userSelectFilter() {
        homePage.tap_changeView_icon();
        homePage.tap_FilterIcon();
        homePage.tap_HighToLow();
    }

    @Then("compare first product price with second product price")
    public void compareProductPrice() {
        HomePage.comparePrices(androidDriver);
    }
}
