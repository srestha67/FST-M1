package activities;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.SkipException;
public class Activity2 {

    WebDriver driver;
    @Test
    public void testCase2() {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        String actual_heading =driver.findElement(By.className("entry-title")).getText();
        System.out.println("The actual heading is " + actual_heading);
        String Expected_heading="Welcome to Alchemy Jobs";
        Assert.assertEquals(Expected_heading, actual_heading);
        driver.quit();

    }
}
