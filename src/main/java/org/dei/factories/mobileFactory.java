package com.shidqiadiatma.factories;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class mobileFactory {

    public AndroidDriver launchMobile(String platformType) throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        URL url = new URL("http://localhost:4723/wd/hub");
        String pathApk = System.getProperty("user.dir") + File.separator + "src/main/resources/build/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";

        dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID.toString());
        dc.setCapability(MobileCapabilityType.APP, pathApk);
        dc.setCapability(MobileCapabilityType.NO_RESET, false);
        dc.setCapability(MobileCapabilityType.TIMEOUTS, 10000);
        dc.setCapability("appPackage", "com.swaglabsmobileapp");
        dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");



        if (platformType.equalsIgnoreCase("Emulator Android")) {
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 6");
        } else if (platformType.equalsIgnoreCase("Real Devices")) {
            dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
            dc.setCapability(MobileCapabilityType.DEVICE_NAME, "RR8N2059SAE");
        }
        return new AndroidDriver(url, dc);
    }
}
