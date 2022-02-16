import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.connection.ConnectionState;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.mobile.NetworkConnection;
import settings.Base;

import java.net.MalformedURLException;
import java.sql.Connection;

public class InstallUninstall extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

        //Before close
        System.out.println("Before close app: "+driver.currentActivity());
        driver.closeApp();

        //After close
        System.out.println("After close app: "+driver.currentActivity());

        //Launch again
        driver.launchApp();
        System.out.println("After launch: "+driver.currentActivity());

        //Check if is installed
        System.out.println("App installed?: "+driver.isAppInstalled("io.appium.android.apis"));

        //Remove app
        driver.removeApp("io.appium.android.apis");
        System.out.println("App installed?: "+driver.isAppInstalled("io.appium.android.apis"));

        /****LOCK AND UNLOCK****/
        driver.lockDevice();
        System.out.println("After lock is device locked: " + driver.isDeviceLocked());

        driver.unlockDevice();
        System.out.println("After unlock is device locked: " + driver.isDeviceLocked());

    }
}
