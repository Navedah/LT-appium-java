import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class vanilla_android {
    public static String userName = System.getenv("LT_USERNAME") == null ? "Username"  //Add username here
            : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "Access_Key" //Add accessKey here
            : System.getenv("LT_ACCESS_KEY");

    private static AppiumDriver driver;

    public static void main(String args[]) throws MalformedURLException, InterruptedException {

        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            // capabilities.setCapability("deviceName", "Galaxy S20"); // change device name for IOS
            // capabilities.setCapability("platformVersion", "11"); // change platform version for IOS
            // capabilities.setCapability("platformName", "Android"); // change platform name for IOS
            // capabilities.setCapability("isRealMobile", true); 
            // capabilities.setCapability("app", "lt://APP10160531401673784532485412"); //Enter your app url // // change app URL for IOS
            // capabilities.setCapability("deviceOrientation", "PORTRAIT");
            // capabilities.setCapability("build", "Java Vanilla - Android");
            // capabilities.setCapability("name", "Sample Test Java");
            // capabilities.setCapability("console", true); 
            // capabilities.setCapability("network", false);
            // capabilities.setCapability("visual", true);
            // capabilities.setCapability("devicelog", true);
            // DesiredCapabilities capabilities = new DesiredCapabilities();
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("w3c", true);
            ltOptions.put("platformName", "android");
            ltOptions.put("deviceName", "Galaxy S20");
            ltOptions.put("platformVersion", "11");
            ltOptions.put("isRealMobile", true);
            ltOptions.put("app", "lt://APP10160531401673784532485412");
            ltOptions.put("build", "Java Vanilla1 - Android");
            ltOptions.put("name", "Sample Test Java 1");
            capabilities.setCapability("lt:options", ltOptions);

            driver = new AppiumDriver(new URL("https://" +userName + ":" + accessKey + "@mobile-hub.lambdatest.com/wd/hub"), capabilities);

            WebElement color = driver.findElement(By.id("com.lambdatest.proverbial:id/color"));
            color.click();

            WebElement text = driver.findElement(By.id("com.lambdatest.proverbial:id/Text"));
            //Changes the text to proverbial
            text.click();

            //toast is visible
            WebElement toast =  driver.findElement(By.id("com.lambdatest.proverbial:id/toast"));
            toast.click();

            //notification is visible
            WebElement notification = driver.findElement(By.id("com.lambdatest.proverbial:id/notification"));
            notification.click();

            //Open the geolocation page
            WebElement geo = driver.findElement(By.id("com.lambdatest.proverbial:id/geoLocation"));
            geo.click();
            Thread.sleep(5000);

            //takes back to home page
            // WebElement el3 = driver.findElement(By.id("Home"));

            driver.navigate().back();
            Thread.sleep(2000);

            //Takes to speed test page
            WebElement speedtest = driver.findElement(By.id("com.lambdatest.proverbial:id/speedTest"));
            speedtest.click();
            Thread.sleep(5000);

            driver.navigate().back();

            //Opens the browser
            // WebElement browser =  driver.findElement(AppiumBy.AccessibilityId("Browser"));
            // browser.click();

            // WebElement url =  driver.findElement(By.id("com.lambdatest.proverbial:id/url"));
            // url.sendKeys("https://www.lambdatest.com");
            // WebElement find = driver.findElement(By.id("com.lambdatest.proverbial:id/find"));
            // find.click();

        } catch (AssertionError a) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=failed");
            a.printStackTrace();
        }
// The driver.quit statement is required, otherwise the test continues to execute, leading to a timeout.
        driver.quit();
    }
    }
