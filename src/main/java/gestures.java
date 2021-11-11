
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class gestures extends base {

    @BeforeClass
    public void setUp() {
        intializeDriver("MyPieEmulator", "uiautomator2", "C:\\Apk\\ApiDemos-debug.apk");
        driver = getDriver();
    }

    @Test
    public void gesturesTest() throws Exception {
        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        tapOnScreen(views);
        Thread.sleep(2000);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        tapOnScreen(expandList);
        Thread.sleep(1000);
        WebElement customAdapter = driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
        tapOnScreen(customAdapter);
        WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
        longPressOnScreen(peopleNames, 2);
    }

    @Test
    public void swipingTest() {
        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        tapOnScreen(views);
        WebElement dateWidgets = driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']");
        tapOnScreen(dateWidgets);
        WebElement inline = driver.findElementByXPath("//android.widget.TextView[@text='2. Inline']");
        tapOnScreen(inline);
        WebElement nine = driver.findElementByXPath("//*[@content-desc='9']");
        tapOnScreen(nine);
        WebElement fifteen = driver.findElementByXPath("//*[@content-desc='15']");
        WebElement fourtyFive = driver.findElementByXPath("//*[@content-desc='45']");
        swipeFromOneElementToAnother(fifteen, 2, fourtyFive);

    }

    @Test
    public void scrollingTest() {
        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        tapOnScreen(views);
        scrollTillGivenText("WebView");

    }

    @Test
    public void dragAndDropTest() {
        WebElement views = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
        tapOnScreen(views);
        WebElement dragAndDrop = driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']");
        tapOnScreen(dragAndDrop);
        WebElement source = driver.findElementsByClassName("android.view.View").get(0);
        WebElement destination = driver.findElementsByClassName("android.view.View").get(2);
        dragAndDrop(source, 3, destination);


    }


}
