package Pages;

import org.openqa.selenium.By;

import static Tests.SeleniumTest.driver;

public class HomePage {

    public static String hamburger_meu_xpath = "//*[@id=\"menuToggle\"]/input";

    public static String online_products_link = "//*[@id=\"menu\"]/a[3]/li";

    //methods of operation perform
    public static void click_hamburger_menu(){
        driver.findElement(By.xpath(hamburger_meu_xpath)).click();
    }

    public static void click_order_products_link() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(online_products_link)).click();
    }
}
