package types;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import settings.Base;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class Browser extends Base {

    @Test
    public void TestingServer() throws MalformedURLException {
        AndroidDriver<AndroidElement> driver = capabilities("Chrome");
        driver.get("https://www.cricbuzz.com");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//*[contains(text(),'Menu')])[1]")).click();
        driver.findElement(By.cssSelector("[title='Cricbuzz Home']")).click();
        WebElement topStories = driver.findElement(By.xpath("//*[contains(text(),'Top Stories')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",topStories);
    }
}
