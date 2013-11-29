package de.orchit.java.selenium;


import de.orchit.java.selenium.pageobjects.FindOwnersPage;
import de.orchit.java.selenium.pageobjects.Homepage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

public class PetClinicHomeTest {
    static WebDriver driver;
    private final String url;

    public PetClinicHomeTest() {
        url = "http://10.100.10.122:9966";
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
    public void checkHomepageForDE() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("de");
        homepage.checkWelcomeMessage("Willkommen");
    }

    @Test
    public void checkHomepageEN() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("en");
        homepage.checkWelcomeMessage("Welcome");
    }

    @Test
    public void createOwner() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("en");
        final FindOwnersPage findOwnersPage = homepage.clickFindOwners();

        findOwnersPage.clickAddOwner();
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("Hans");
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("Dampf");
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("HereStreet 42");
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys("therecity");
        driver.findElement(By.id("telephone")).clear();
        driver.findElement(By.id("telephone")).sendKeys("987654321");
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        assertEquals("Hans Dampf", driver.findElement(By.cssSelector("b")).getText());
        assertEquals("HereStreet 42", driver.findElement(By.xpath("//tr[2]/td")).getText());
        assertEquals("therecity", driver.findElement(By.xpath("//tr[3]/td")).getText());
        assertEquals("987654321", driver.findElement(By.xpath("//tr[4]/td")).getText());
    }


}
