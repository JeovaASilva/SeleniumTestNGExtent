package Pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.IOException;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductsPage {

    public static String formal_shoes_xpath = "/html/body/div[2]/center/h2";

    public static String sport_shoes_xpath = "/html/body/div[3]/center/h2";

    public static String sneakers_xpath = "/html/body/div[4]/center/h2";

    public static String formal_shoesdrpdown_xpath = "/html/body/div[2]/center/div/i[1]";

    public static String sport_shoesdrpdown_xpath = " /html/body/div[3]/center/div/i[1]";

   // public static String sneakers_shoesdrpdown_xpath = "/html/body/div[4]/center/div/i[1]";

    public static String formalShoes_firstshoename = "/html/body/div[2]/table/tbody/tr[1]/td[1]";

    public static String sportShoes_firstshoename = "/html/body/div[3]/table/tbody/tr[1]/td[1]";


    //methods of operation perform
    public static void formal_shoes_get_title(){

    }

    public static void formalShoes_verifyTitle() throws IOException {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFs =  driver.findElement(By.xpath(formal_shoes_xpath)).getText();
        Assert.assertEquals(expectedTitleFS, actualTitleFs);
        if(expectedTitleFS.equals(actualTitleFs)){
            test.log(Status.PASS, "Test Passed for title verification of Formal Shoes");
            test.log(Status.PASS, test.addScreenCaptureFromPath(capture(driver)) + "Test Passed" );
        } else if (false){
            test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());
        }
    }

    public static void sport_shoes_verifyTitle() throws IOException, InterruptedException{
        Thread.sleep(2000);
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS =  driver.findElement(By.xpath(sport_shoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);
        if(expectedTitleSS.equals(actualTitleSS)){
            test.log(Status.PASS, "Test Passed for title verification of Sport Shoes");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Test Failed" );
        }
    }
    public static void sneakers_verifyTitle()throws IOException, InterruptedException{
        String expectedTitleSn = "Sneakers";
        String actualTitleSn =  driver.findElement(By.xpath(sneakers_xpath)).getText();
        Assert.assertEquals(expectedTitleSn, actualTitleSn);
        if(expectedTitleSn.equals(actualTitleSn)){
            test.log(Status.PASS, "Test Passed for title verification of Sneakers Shoes");
            test.log(Status.FAIL, test.addScreenCaptureFromPath(capture(driver)) + "Test Failed" );
        }
    }

    public static void formal_shoes_verify(){
        String expectedFirstFormalShoe = "   Classic Cheltenham";
        driver.findElement(By.xpath(formal_shoesdrpdown_xpath)).click();
        String actualFirstFormalshoe = driver.findElement(By.xpath(formalShoes_firstshoename)).getText();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalshoe);
        if(expectedFirstFormalShoe.equals(actualFirstFormalshoe)){
            test.log(Status.PASS, "Test Passed for title verification of Formal Shoes");
        }
    }

    public static void sportShoes_firstshoe_verify(){
        String expectedFirstSportShoe = "   Ultimate";
        driver.findElement(By.xpath(sport_shoesdrpdown_xpath)).click();
        String actualFirstSportlshoe = driver.findElement(By.xpath(sportShoes_firstshoename)).getText();
        Assert.assertEquals(expectedFirstSportShoe, actualFirstSportlshoe);
        if(expectedFirstSportShoe.equals(actualFirstSportlshoe)){
            test.log(Status.PASS, "Test Passed for title verification of Formal Shoes");
        }
    }





}
