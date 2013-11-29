package de.orchit.java.selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.UUID;

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

    @Test
    public void createUser() throws InterruptedException {
        driver.get(url + "/");
        driver.findElement(By.id("jRegisterLink")).click();
        new Select(driver.findElement(By.id("registerView.userAddress.gender"))).selectByVisibleText("Frau");
        driver.findElement(By.id("registerView.userAddress.gender")).click();
        driver.findElement(By.id("registerView.userAddress.firstName")).clear();
        driver.findElement(By.id("registerView.userAddress.firstName")).sendKeys("Helmine");
        driver.findElement(By.id("registerView.userAddress.lastName")).clear();
        driver.findElement(By.id("registerView.userAddress.lastName")).sendKeys("Stranger");
        driver.findElement(By.id("registerView.userAddress.street")).clear();
        driver.findElement(By.id("registerView.userAddress.street")).sendKeys("SecretStreet");
        driver.findElement(By.id("registerView.userAddress.streetNumber")).clear();
        driver.findElement(By.id("registerView.userAddress.streetNumber")).sendKeys("23");
        driver.findElement(By.id("registerView.userAddress.postalCode")).clear();
        driver.findElement(By.id("registerView.userAddress.postalCode")).sendKeys("54321");
        driver.findElement(By.id("registerView.userAddress.cityName")).clear();
        driver.findElement(By.id("registerView.userAddress.cityName")).sendKeys("SecretCity");
        driver.findElement(By.id("registerView.email")).clear();
        driver.findElement(By.id("registerView.email")).sendKeys(UUID.randomUUID().toString() + "@example.com");
        new Select(driver.findElement(By.id("birthDay"))).selectByVisibleText("19");
        new Select(driver.findElement(By.id("birthMonth"))).selectByVisibleText("Februar");
        new Select(driver.findElement(By.id("birthYear"))).selectByVisibleText("1968");
        driver.findElement(By.id("registerView.password")).clear();
        driver.findElement(By.id("registerView.password")).sendKeys("superSecret!");
        driver.findElement(By.id("passwordRepeat")).clear();
        driver.findElement(By.id("passwordRepeat")).sendKeys("superSecret!");
        driver.findElement(By.id("newsletterSubscribe")).click();
        driver.findElement(By.id("agbAccepted")).click();
        driver.findElement(By.id("newsletterSubscribe")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("jSubmitRegistrationBtn")).click();

        assertEquals("Helmine Stranger", driver.findElement(By.id("jUserArea")).getText());


    }
}
