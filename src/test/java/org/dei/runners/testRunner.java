package com.shidqiadiatma.runners;

import com.shidqiadiatma.factories.driverManager;
import com.shidqiadiatma.factories.mobileFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import java.net.MalformedURLException;

@CucumberOptions(
        features = "src/test/java/com/shidqiadiatma/features",
        glue = "com.shidqiadiatma.steps",
        tags = "@sorting",
        plugin = {
                "pretty",
                "html:reports/cucumber-result/cucumber-reports.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:reports/cucumber-result/cucumber-reports.json"
        },
        monochrome = true
)
public class testRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider()
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod(alwaysRun = true)
    public void setupDriver() {
        try {
            driverManager.getInstance().setDriver(new mobileFactory().launchMobile("Emulator Android"));
        } catch (MalformedURLException e) {
            System.err.println("Error setting up the driver: " + e.getMessage());
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownDriver() {
        driverManager.getInstance().removeDriver();
    }
}
