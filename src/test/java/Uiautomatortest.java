import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import settings.Base;

import java.net.MalformedURLException;

public class Uiautomatortest extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        //Check elements are not clickable
        int numberOfClickable=driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        Assert.assertEquals(numberOfClickable, 0);
    }
}
