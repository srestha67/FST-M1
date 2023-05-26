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

public class Activity7 {
    WebDriver driver;

    @Test
    public void testCase7() throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        WebElement navigationBar = driver.findElement(By.id("primary-menu"));
        WebElement menuItem = navigationBar.findElement(By.linkText("Post a Job"));
        menuItem.click();
        Thread.sleep(2000);
        driver.findElement(By.id("create_account_email")).sendKeys("srestha.mohanty@gtensql.com");
        driver.findElement(By.id("job_title")).sendKeys("Testing");
        WebElement job_type_dropdown= driver.findElement(By.id("job_type"));
        Select select = new Select(job_type_dropdown);
        select.selectByIndex(1);
        driver.findElement(By.id("job_description_ifr")).sendKeys("test");
        driver.findElement(By.id("application")).sendKeys("application@gmail.com");
        driver.findElement(By.id("company_name")).sendKeys("ibm");
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        driver.findElement(By.id("job_preview_submit_button")).click();
        // validate the job is created successfully
        String actual_msg=driver.findElement(By.xpath("//div[@class='entry-content clear']")).getText();
        if(actual_msg.contains("Job listed successfully.")){
           System.out.println("Job created successsfully");
           //navigating to the listing view
           // driver.findElement(By.linkText("click here")).click();
        } else {
            System.out.println("Job is not created");
        }
        Thread.sleep(4000);
        //WebElement navigationBar = driver.findElement(By.id("primary-menu"));
        //WebElement Job_tab = navigationBar.findElement(By.linkText("Jobs"));
        driver.navigate().refresh();
        Alert alt = driver.switchTo().alert();
        alt.accept();


       try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Jobs")));
             element.click();
        } catch (StaleElementReferenceException e) {

            }


        Thread.sleep(2000);
        driver.findElement(By.id("search_keywords")).sendKeys("Testing");
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        Thread.sleep(6000);
        int no_of_jobs=driver.findElements(By.xpath("//ul[@class='job_listings']//li")).size();
        Thread.sleep(5000);
        for(int i=1;i<no_of_jobs;i++){
            String element=driver.findElement(By.xpath("//ul[@class='job_listings']/li["+i+"]/a/div/h3")).getText();
            if(element.equalsIgnoreCase("Testing")) {
                System.out.println("Validated that the job "+element+ " is posted successfully.");
                break;
            }else{
                //System.out.println("The job is not listed");
            }

            }
        driver.close();
        }



}
