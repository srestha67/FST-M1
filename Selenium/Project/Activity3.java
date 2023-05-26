package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;

    @Test
    public void testCase3() {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        String img_url = driver.findElement(By.xpath("//img[@class='attachment-large size-large wp-post-image']")).getAttribute("src");
        System.out.println("The url of the header image is " +img_url);
        driver.close();
    }
}
