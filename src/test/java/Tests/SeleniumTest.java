package Tests;

import Pages.HomePage;
import Pages.ProductsPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class SeleniumTest {

    public static WebDriver driver;

    static ExtentReports report;

    public static ExtentTest test;

    static ExtentReports extent = new ExtentReports();

    @BeforeSuite
    public static void Setup() throws InterruptedException{
        driver = new ChromeDriver();
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);

        HomePage.click_hamburger_menu();
        HomePage.click_order_products_link();
    }

    public static String capture(WebDriver driver) throws IOException, IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File Dest = new File("scr/../ExecImages/" + System.currentTimeMillis() + ".png");
        String errflpath = Dest.getAbsolutePath();
        FileUtils.copyFile(scrFile, Dest);
        return errflpath;
    }

    @Test
    void validateTitles_OnlineProduts() throws InterruptedException, IOException{
        test = extent.createTest("Validate Shoe titles no Product page","This test validates that the different Shoetypes are correct on Online Products Page");
        ProductsPage.formalShoes_verifyTitle();
        ProductsPage.sport_shoes_verifyTitle();
        ProductsPage.sneakers_verifyTitle();
        extent.flush();

    }
    @Test
    void validateFirstFormalShoe(){
        test = extent.createTest("Validate First Formal Shoe name","This test validates first formal Shoes on the Products Page");
        ProductsPage.formal_shoes_verify();
    }
    @Test
    void validateFirstSportShoe(){
        test = extent.createTest("Validate First Sport Shoe name","This test validates first sport Shoes on the Products Page");
        ProductsPage.sportShoes_firstshoe_verify();
    }
    @AfterSuite
    public static void cleanup(){
        extent.flush();
    }

}
