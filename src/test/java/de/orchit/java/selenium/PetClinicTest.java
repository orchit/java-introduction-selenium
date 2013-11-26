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

import static org.junit.Assert.assertEquals;

public class PetClinicTest {
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

    @Test
    public void createOwner() {
        driver.get("http://localhost:9966/petclinic?lang=en");
        WelcomePage welcomePage = new WelcomePage(driver);
        final FindOwnerPage findOwnerPage = welcomePage.goToFindOwners();
        final AddOwnerPage page = findOwnerPage.goToAddOwner();

        page.setFirstName("Hans");
        page.setLastName("Dampf");
        page.setAddress("HereStreet 42");
        page.setCity("therecity");
        page.setTelephone("987654321");
        page.submit();

        assertEquals("Hans Dampf", driver.findElement(By.cssSelector("b")).getText());
        assertEquals("HereStreet 42", driver.findElement(By.xpath("//tr[2]/td")).getText());
        assertEquals("therecity", driver.findElement(By.xpath("//tr[3]/td")).getText());
        assertEquals("987654321", driver.findElement(By.xpath("//tr[4]/td")).getText());
    }


}
