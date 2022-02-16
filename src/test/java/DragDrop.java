import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import settings.Base;

import java.net.MalformedURLException;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDrop extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        driver.findElement(By.xpath("//android.widget.TextView[@text='Views']")).click();

        //Drag and drop
        driver.findElement(By.xpath("//android.widget.TextView[@text='Drag and Drop']")).click();
        TouchAction actions = new TouchAction(driver);

        WebElement origin = driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination = driver.findElementsByClassName("android.view.View").get(1);

        //actions.longPress(longPressOptions().withElement(element(origin))).moveTo(element(destination)).release().perform();
        actions.longPress(element(origin)).moveTo(element(destination)).release().perform();

    }

}
