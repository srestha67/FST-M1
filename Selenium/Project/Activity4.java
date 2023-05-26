package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Activity4 {

    WebDriver driver;

    @Test
    public void testCase4() {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        String Second_header=driver.findElement(By.tagName("h2")).getText();
        System.out.println("The actual header is " +Second_header);
        String Expected_header="Quia quis non";
        Assert.assertEquals(Expected_header, Second_header);
        driver.close();
    }
}
