package de.orchit.java.selenium;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class PetClinicHomeTest {
    static WebDriver driver;

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
        driver.get("http://localhost:9966/petclinic?lang=de");
        final List<WebElement> elements = driver.findElements(By.tagName("h2"));
        Assert.assertEquals(1, elements.size());
        Assert.assertEquals("Willkommen", elements.get(0).getText());
    }

    @Test
    public void checkHomepageEN() {
        driver.get("http://localhost:9966/petclinic?lang=en");
        final List<WebElement> elements = driver.findElements(By.tagName("h2"));
        Assert.assertEquals(1, elements.size());
        Assert.assertEquals("Welcome", elements.get(0).getText());
    }
}
