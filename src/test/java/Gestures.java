import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import settings.Base;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Gestures extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

        //Tap
        TouchAction actions = new TouchAction(driver);
        WebElement expandList = driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
        actions.tap(tapOptions().withElement(element(expandList))).perform();

        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")).click();

        //Tap and hold
        WebElement peopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        actions.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();

        Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
    }
}
