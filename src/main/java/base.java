import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class base {

    AndroidDriver<?> driver;

    public AndroidDriver<?> getDriver() {
        return driver;
    }

    public void setDriver(AndroidDriver<?> driver) {
        this.driver = driver;
    }

    public AndroidDriver<?> intializeDriver(String deviceName, String automationName, String appPath) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
        capabilities.setCapability(MobileCapabilityType.APP, appPath);

        try {
            driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            setDriver(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }

    public TouchAction getTouchActions() {
        return new TouchAction<>(getDriver());
    }

    public void tapOnScreen(WebElement element) {
        getTouchActions().tap(tapOptions().withElement(element(element))).perform();
    }

    public void longPressOnScreen(WebElement element, int duration) {
        getTouchActions().longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(duration))).release().perform();
    }

    public void swipeFromOneElementToAnother(WebElement firstElement, int holdDuration, WebElement secondElement) {
        getTouchActions().longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(holdDuration))).moveTo(element(secondElement)).release().perform();
    }

    public void scrollTillGivenText(String text) {
        getDriver().findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text.trim()+"\"));");
    }

    public void dragAndDrop(WebElement firstElement, int holdDuration, WebElement secondElement) {
        getTouchActions().longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(holdDuration))).moveTo(element(secondElement)).release().perform();
    }

}
