package activities;
import org.openqa.selenium.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.SkipException;

public class Activity1 {




        WebDriver driver;

        @Test
        public void testCase1() {
            // Setup the Firefox driver(GeckoDriver)
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            WebDriverManager.firefoxdriver().setup();

            //Create a new instance of the Firefox driver
            driver = new FirefoxDriver();


            // Open the browser
            driver.get("https://alchemy.hguy.co/jobs");
            String actual_title = driver.getTitle();
            String expected_title = "Alchemy Jobs – Job Board Application";

            System.out.println("The actual title is" + actual_title);
            Assert.assertEquals(expected_title, actual_title);
            driver.quit();
            }

            }





