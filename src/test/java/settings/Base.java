package settings;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
        AndroidDriver<AndroidElement> androidDriver;
        if(device.equalsIgnoreCase("chrome")){
            androidDriver = new AndroidDriver<AndroidElement>(new ServerSetup().getServer().getUrl(), getCapabilities("chrome"));
        }else {
            androidDriver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), getCapabilities(device));
        }
        return androidDriver;
    }

    public static DesiredCapabilities getCapabilities(String device){
        File file = new File("src/test/java");
        File fs = new File(file,"Raaga.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (device.toUpperCase()){
            case "REDMI":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi Note 9S");
                capabilities.setCapability(MobileCapabilityType.UDID,"192.168.0.4:5555");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11 RKQ1.200826.002");
                //capabilities.setCapability("appPackage","io.appium.android.apis");
                //capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
                //capabilities.setCapability("appPackage","com.android.camera");
                //capabilities.setCapability("appActivity","com.android.camera.Camera");
                capabilities.setCapability("appPackage","com.raaga.android");
                capabilities.setCapability("appActivity","com.raaga.android.activity.HomeActivity");
                break;
            case "CHROME":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi Note 9S");
                capabilities.setCapability(MobileCapabilityType.UDID,"192.168.0.7:5555");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11 RKQ1.200826.002");
                capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
                break;
            case "AVD":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Nexus");
                capabilities.setCapability(MobileCapabilityType.UDID,"emulator-5554");
                capabilities.setCapability(MobileCapabilityType.APP,fs.getAbsolutePath());
                break;
            default:
                Assert.fail("Device not found.");
                break;
        }
        return capabilities;
    }

    @AfterClass
    public void after(){
        new ServerSetup().StopServer();
    }
}
