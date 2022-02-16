package types;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import settings.Base;

import java.net.MalformedURLException;
import java.util.Set;

public class Hybrid extends Base {
    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("Redmi");
        System.out.println(driver.getContext());
        Set<String> contextHandles = driver.getContextHandles();
        for(String handle:contextHandles){
            System.out.println(handle);
        }
        //NATIVE_APP WEBVIEW_com.example.testapp
        driver.context("WEBVIEW_com.example.testapp"); //To switch driver to webapp
        driver.findElement(By.name("q")).sendKeys("It is working!!!");
        driver.context("NATIVE_APP"); //To go back to native app part
    }
}
