import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import settings.Base;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Basics extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("redmi");
        WebDriverWait wait = new WebDriverWait(driver,20);

        /*driver.findElementById("android:id/button1").click();
        driver.findElementById("com.android.permissioncontroller:id/permission_allow_one_time_button").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button"))).click();
        driver.findElementById("com.android.camera:id/v9_camera_picker").click();
        driver.findElementById("com.android.camera:id/shutter_button").click();*/


        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        driver.findElementById("android:id/checkbox").click();
        driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
        driver.findElementById("android:id/edit").sendKeys("Angelitooooooo");
        driver.findElementById("android:id/button1").click();
        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")),"WiFi settings")));

        //Orientation
        System.out.println(driver.getOrientation());
        driver.rotate(ScreenOrientation.LANDSCAPE);
        System.out.println(driver.getOrientation());
        driver.rotate(ScreenOrientation.PORTRAIT);

    }
}
