package org.dei.steps;

import org.dei.factories.driverManager;
import org.dei.helpers.randomData;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.dei.pages.*;
public class checkoutStep {

    private final HomePage homePage;
    private final YourCartPage yourCartPage;
    private final CheckoutInformationPage checkoutInformationPage;
    private final CheckoutOverviewPage checkoutOverviewPage;
    private final CheckoutCompletePage checkoutCompletePage;

    public checkoutStep() {
        AndroidDriver androidDriver = driverManager.getInstance().getDriver();
        homePage = new HomePage(androidDriver);
        yourCartPage = new YourCartPage(androidDriver);
        checkoutInformationPage = new CheckoutInformationPage(androidDriver);
        checkoutOverviewPage = new CheckoutOverviewPage(androidDriver);
        checkoutCompletePage = new CheckoutCompletePage(androidDriver);
    }

    @When("user tap Add To Cart button on first product")
    public void userTapAddToCartButtonOnFirstProduct() {
        homePage.add_firstProduct_to_cart();
    }

    @And("user tap Add To Cart button on second product")
    public void userTapAddToCartButtonOnSecondProduct() {
        homePage.add_secondProduct_to_cart();
    }

    @And("user tap Cart icon")
    public void userTapCartIcon() {
        homePage.tap_cartIcon();
    }

    @And("user tap Checkout button on Your Cart page")
    public void userTapCheckoutButton() {
        yourCartPage.tap_checkoutButton();
    }

    @And("user fill in Checkout Information")
    public void userFillInCheckoutInformation() {
        checkoutInformationPage.verify_Component_OnCheckoutInformation();
        checkoutInformationPage.fill_checkoutInformation(
                randomData.getFirstName(),
                randomData.getLastName(),
                randomData.getPostalCode()
        );
    }

    @And("user tap Finish button on Checkout Overview page")
    public void userTapFinishButtonOnCheckoutOverviewPage() {
        checkoutOverviewPage.tap_finishButton();
    }

    @Then("user verify success checkout")
    public void userVerifySuccessCheckout() {
        checkoutCompletePage.verify_component_OnCheckoutComplete();
    }
}
