package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Activity6 {
    WebDriver driver;

    @Test
    public void testCase6() throws InterruptedException , IOException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/");
        WebElement navigationBar = driver.findElement(By.id("primary-menu"));
        WebElement menuItem = navigationBar.findElement(By.linkText("Jobs"));
        menuItem.click();
        Thread.sleep(2000);

        driver.findElement(By.id("search_keywords")).sendKeys("QA Tester");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        Thread.sleep(2000);



        int no_of_jobs=driver.findElements(By.xpath("//ul[@class='job_listings']//li")).size();
        for(int i=1;i<no_of_jobs;i++){
            WebElement First_Element=driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a/div/h3"));
            First_Element.click();
            break;
        }

        driver.findElement((By.xpath("//input[@class='application_button button']"))).click();
        WebElement emailElement = driver.findElement(By.tagName("a"));
        Thread.sleep(500);

        WebElement email = driver.findElement(By.xpath("//a[@class='job_application_email']"));
        System.out.println("Job application email: " + email.getText());

        Thread.sleep(2000);
        driver.close();


    }
}
