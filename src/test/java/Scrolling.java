import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.Base;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Scrolling extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

        //Appium doesn't support scroll, we need to use android driver
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");

        }

}
