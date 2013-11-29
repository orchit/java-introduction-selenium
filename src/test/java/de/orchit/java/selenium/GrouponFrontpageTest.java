package de.orchit.java.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: pcornelissen
 * Date: 29.11.13
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class GrouponFrontpageTest {
    static WebDriver driver;
    private final String url;

    public GrouponFrontpageTest() {
        url = "http://www.groupon.de";
    }

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void checkForSchlossBrandenburgInReisenCategory() {
        driver.get(url);
        driver.findElement(By.id("jTRAVEL")).click();
        driver.findElement(By.id("newsletter_already_sign_up")).click();
        driver.findElement(By.xpath("//div[@id='thumbs']/div[2]")).click();
        new Select(driver.findElement(By.id("tag_filter_3"))).selectByVisibleText("Deutschland");
        driver.findElement(By.xpath("//div[@id='thumbs']/div[3]")).click();
        new Select(driver.findElement(By.id("tag_filter_22"))).selectByVisibleText("Sommer");
        driver.findElement(By.cssSelector("option[value=\"35\"]")).click();
        driver.findElement(By.id("index-search-button")).click();
        assertEquals("Schloss in Brandenburg", driver.findElement(By.cssSelector("h1")).getText());

    }
}
