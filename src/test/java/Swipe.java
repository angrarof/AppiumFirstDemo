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

public class Swipe extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElement(By.xpath("//*[@content-desc='9']")).click();

        WebElement min15 = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement min45 = driver.findElementByXPath("//*[@content-desc='45']");
        TouchAction actions = new TouchAction(driver);
        actions.longPress(longPressOptions().withElement(element(min15)).withDuration(ofSeconds(2))).moveTo(element(min45)).release().perform();

    }

}
