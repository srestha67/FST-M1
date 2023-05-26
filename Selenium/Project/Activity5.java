package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Activity5 {

    WebDriver driver;

    @Test
    public void testCase5() throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement navigationBar = driver.findElement(By.id("primary-menu"));
        WebElement menuItem = navigationBar.findElement(By.linkText("Jobs"));
        menuItem.click();
        Thread.sleep(2000);
        String page_title=driver.getTitle();
        System.out.println("The page title is " +page_title);
        if(page_title.equalsIgnoreCase("Jobs – Alchemy Jobs")){
            System.out.println("Title matched");
        }else{
            System.out.println("Title didnot matched");
        }
        driver.close();

    }
}
