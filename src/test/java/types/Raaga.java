package types;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import settings.Base;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Run emulator: emulator -avd Nexus
public class Raaga extends Base {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        AndroidDriver<AndroidElement> driver = capabilities("avd");
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.findElementByAndroidUIAutomator("text(\"LATER\")").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Swipe pages
        Dimension dimension = driver.manage().window().getSize();
        int x1 = (int) (dimension.getWidth() * (.75));
        int x2 = (int) (dimension.getWidth() * (.1));
        int y = (int) (dimension.getHeight() * (.5));

        PointOption pointOptionStart, pointOptionEnd;
        pointOptionStart = PointOption.point(x1,y);
        pointOptionEnd = PointOption.point(x2,y);

        TouchAction action = new TouchAction(driver);
        action.press(pointOptionStart).moveTo(pointOptionEnd).release().perform();
        action.press(pointOptionStart).moveTo(pointOptionEnd).release().perform();
        //End swipe

        driver.findElementByXPath("//android.widget.TextView[@text='Done']").click();
        driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
        driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
        driver.findElementById("com.raaga.android:id/toolbar_logo").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Push Notification']").click();

        Point notifyToggleLocation = driver.findElementById("com.raaga.android:id/toggle_notifyrecommend").getLocation();
        PointOption notifyOn = PointOption.point(notifyToggleLocation.x+20,notifyToggleLocation.y+30);
        action.tap(notifyOn).perform();
        PointOption notifyOff = PointOption.point(notifyToggleLocation.x+100,notifyToggleLocation.y+30);
        action.tap(notifyOff).perform();

        /*driver.findElement(By.xpath("//android.widget.TextView[@text='World Music']/preceding-sibling::android.widget.CheckBox")).click();
        driver.findElementByAndroidUIAutomator("text(\"Continue\")").click();
        driver.findElementById("com.raaga.android:id/action_discover").click();

        WebElement parentElement = driver.findElementById("com.raaga.android:id/item_recycler_view");
        List<AndroidElement> childElements = parentElement.findElements(By.id("com.raaga.android:id/card_view"));
        childElements.get(0).findElementById("My id");
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(index(53));");*/


        /*int numberElements = 0;
        boolean flag = true;
        while (flag){
            try {
                String lastElement = childElements.get(numberElements).findElementById("com.raaga.android:id/tv_title").getText();
                System.out.println(lastElement);
                driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+lastElement+"\"));");
                numberElements++;
            }catch (IndexOutOfBoundsException e){
                System.out.println("last element reached.");
                flag = false;
            }
        }*/

        /*driver.navigate().back();
        driver.findElementById("com.raaga.android:id/skip_login_btn").click();
        driver.findElementById("com.raaga.android:id/signup_btn");
        driver.navigate().back();*/

        /*wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.Button[@text='Explore']")))).click();
        driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").get(7).click();
        driver.findElementByAndroidUIAutomator("text(\"CONTINUE\")").click();
        driver.findElementByAndroidUIAutomator("text(\"SKIP\")").click();
        driver.findElementByAndroidUIAutomator("text(\"REMIND ME LATER\")").click();*/

        /*REMIND ME LATER android.widget.Button android:id/button2
        Sign Up with your email
                click back*/


    }
}
