package automation.shine;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ShineJobAutomation {
    static WebDriver driver;

    public static void main(String[] args) {
        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Step 1: Navigate to Shine Jobs login page
            driver.get("https://www.shine.com/myshine/login/");
            System.out.println("Page Title: " + driver.getTitle());
            System.out.println("Current URL: " + driver.getCurrentUrl());

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            // Enter login credentials
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_email_login")))
                    .sendKeys("akash.k.mishra03@gmail.com");
            driver.findElement(By.id("id_password")).sendKeys("Zxcvbnm@123");

            // Click Login button
            driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

            // Wait until homepage/dashboard loads
            wait.until(ExpectedConditions.urlContains("myshine/mydashboard/"));
            takeScreenshot("login_success.png");

            // Step 2: Search for a Job
            // Click on the search box container first
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("skills")));
            searchBox.click();

            // Enter skills, location, and experience
            driver.findElement(By.id("id_q")).sendKeys("Software Tester");
            driver.findElement(By.id("id_loc")).sendKeys("Hyderabad");
            driver.findElement(By.id("searchBar_experience")).sendKeys("2");

            takeScreenshot("search_details_entered.png");

            driver.findElement(By.id("id_new_search_submit_button")).click();

            // Wait until search results load
           // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'jobCard_jobCard')]")));
         // Wait until search results load
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'jobCardNova_bigCard__W2xn3')]")
            ));

            // Step 3: Select the second job and apply
            List<WebElement> jobList = driver.findElements(By.xpath("//div[contains(@class,'jobCardNova_bigCard__W2xn3')]"));
            if (jobList.size() >= 2) {
                WebElement secondJob = jobList.get(1);
                String jobTitle = secondJob.findElement(By.cssSelector(".jobCardNova_bigCardTopTitleHeading__Rj2sC.jdTruncation")).getText();
                String companyName = secondJob.findElement(By.cssSelector(".jobCardNova_bigCardTopTitleName__M_W_m.jdTruncationCompany")).getText();
                System.out.println("Job Title: " + jobTitle);
                System.out.println("Company Name: " + companyName);

                // Click on the second job to open its details page
                secondJob.click();

                // Switch to the new tab if it opened
                String originalWindow = driver.getWindowHandle();
                Set<String> handles = driver.getWindowHandles();
                for (String handle : handles) {
                    if (!handle.equals(originalWindow)) {
                        driver.switchTo().window(handle);
                        break;
                    }
                }

                // Wait for the Apply button to be clickable and click it
             // Click Apply button using class
                WebElement applyBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(@class,'jobApplyBtnNova_bigCardBottomApply__z2n7R')]")
                ));
                applyBtn.click();


                // Wait for confirmation message
                WebElement confirmationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Apply') or contains(text(),'Applied') or contains(text(),'Application Submitted')]")));
                System.out.println("Confirmation Message: " + confirmationMsg.getText());
                takeScreenshot("applied_success.png");
            } else {
                System.out.println("Less than 2 jobs found.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    public static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./" + fileName);
            org.openqa.selenium.io.FileHandler.copy(src, dest);
            System.out.println("Screenshot saved: " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
