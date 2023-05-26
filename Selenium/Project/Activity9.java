package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Activity9 {
    WebDriver driver;

    @Test
    public void testCase9() throws InterruptedException {
        // Setup the Firefox driver(GeckoDriver)
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        WebDriverManager.firefoxdriver().setup();

        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();


        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.id("menu-posts-job_listing")).click();
        driver.findElement(By.xpath("//div[@id=\"wpbody-content\"]/div[@class='wrap']/a")).click();
        driver.findElement(By.id("post-title-0")).sendKeys("Test automation");
        driver.findElement(By.xpath("//div[@class='edit-post-header__settings']/button[text()='Publish…']")).click();
        driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-publish-button']/button")).click();
        //Validate that the job title is published
        Thread.sleep(2000);
        String Job_title=driver.findElement(By.id("post-title-0")).getText();
        String publish_message=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div[3]/div/div/div/div[1]/div")).getText();
        if((Job_title.contains("Test automation"))&&(publish_message.contains("Published"))){

            System.out.println("The job "+Job_title+" is "+publish_message+" successfully");
        }else{
            System.out.println("Job is " + publish_message);
            System.out.println("Job will be published sooner");
        }




        driver.close();



    }
}
