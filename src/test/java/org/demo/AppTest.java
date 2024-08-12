package org.demo;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
//import java.net.URL;
import java.net.URL;
import java.time.Duration;

public class AppTest
{
	 AppiumDriver driver;
    @Test
    public void configure() throws MalformedURLException, InterruptedException {
//        AppiumServiceBuilder builder = new AppiumServiceBuilder()
//                .withAppiumJS(new File("/user/local/lib/node_modules/appium/build/lib/main.js"))
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withLogFile(new File(System.getProperty("user.dir") + "/appiumServerLog.txt"));
//        AppiumDriverLocalService service = builder.build();
//        service.start();
//        System.out.println("Starting the Appium Server on 127.0.0.1:4723");

     //  AppiumDriverLocalService service = AppiumDriverLocalService.buildDefaultService();
       //service.stop();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setPlatformVersion("15");
        options.setDeviceName("emulator-5554");
//        options.setPlatformVersion("8.1.0");
//        options.setDeviceName("HNJ02STT");
        options.setApp(System.getProperty("user.dir")+"\\app-release.apk");
        System.out.println(System.getProperty("user.dir")+"\\app-release.apk");
        options.setAutomationName("UiAutomator2");
        
//        DesiredCapabilities options = new DesiredCapabilities();
//        options.setCapability("platformName", "Android");
//        options.setCapability("platformVersion", "8.1.0"); // Replace with your Android version
//        options.setCapability("udid", "HNJ02STT"); // Replace with your device name
//        options.setCapability("automationName", "UiAutomator2");

        options.setCapability("appium:appWaitForLaunch", true);
        options.setCapability("-session-override", true);
        options.setCapability("appPackage", "com.sasai.sasaipay");
        //options.setCapability("appActivity", "android.permission.POST_NOTIFICATIONS");
        options.setCapability("appActivity", "com.sasai.sasaipay.MainActivity");
        options.setCapability("appWaitforLaunch", "false");
        options.setCapability("adbExecTimeout", 50000);
        options.setCapability("autoDismissAlerts", true);
        options.setCapability("autoGrantPermission", true);
        options.setCapability("autoAcceptAlerts", true);
        options.setCapability("disabledLocatorAutocompletion", true);
        //options.setCapability("android.permission.POST_NOTIFICATIONS", true);

        //URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);

//        WebElement notification = driver.findElement(By.id("android:id/button1"));
//        notification.click();

        WebElement element = driver.findElement(By.xpath("//android.view.View[@content-desc='Get Started']"));
        System.out.println("Element Displayed: "+element.isDisplayed());
        element.click();
        //element.sendKeys("Santhosh");

        Thread.sleep(3000);

        WebElement countryCode = driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'Country code')]"));
        System.out.println("Element Displayed: "+countryCode.isDisplayed());
        countryCode.click();
        driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'United Kingdom (+44)')]")).click();


        WebElement mobile = driver.findElement(By.xpath("//android.widget.EditText"));
        System.out.println("Element Displayed: "+mobile.isDisplayed());
        mobile.click();
        mobile.sendKeys("1234567890");

        Thread.sleep(3000);

        WebElement skip = driver.findElement(By.xpath("//android.view.View[@content-desc='Skip']"));
        System.out.println("Element Displayed: "+skip.isDisplayed());
        skip.click();
    }
}
