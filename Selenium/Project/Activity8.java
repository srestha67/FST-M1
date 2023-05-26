package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;

    @Test
    public void testCase8() throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        WebElement username_field=driver.findElement(By.id("user_login"));
        username_field.sendKeys("root");
        WebElement password_field=driver.findElement(By.id("user_pass"));
        password_field.sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        Thread.sleep(5000);
        //Validate that dashboard page is opened and users name is displayed
        String My_profile_name=driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a/span[@class='display-name']")).getText();
        String dashboard=driver.findElement(By.xpath("//div[@class='wrap']/h1")).getText();
        if((My_profile_name.contains("root"))&&(dashboard.contains("Dashboard"))){
            System.out.println("Dasboard page is displayed with the user's name " +My_profile_name+ ", hence login is successful");
        }else{
            System.out.println("Dasboard page is not displayed with the user's name , hence login is unsuccessful");
        }
      driver.close();

    }
}
