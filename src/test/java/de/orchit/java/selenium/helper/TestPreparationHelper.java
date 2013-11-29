package de.orchit.java.selenium.helper;

import de.orchit.java.selenium.pageobjects.AddOwnerPage;
import de.orchit.java.selenium.pageobjects.FindOwnersPage;
import de.orchit.java.selenium.pageobjects.Homepage;
import de.orchit.java.selenium.pageobjects.OwnerInformationPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: pcornelissen
 * Date: 29.11.13
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
public class TestPreparationHelper {
    public static OwnerInformationPage prepareOwner(Homepage homepage) {
        final FindOwnersPage findOwnersPage = homepage.clickFindOwners();

        final AddOwnerPage addOwnerPage = findOwnersPage.clickAddOwner();

        addOwnerPage.setFirstName("Hans");
        addOwnerPage.setLastName("Dampf");
        addOwnerPage.setAddress("Elm Street");
        addOwnerPage.setCity("thereCity");
        addOwnerPage.setTelephone("987654321");

        final OwnerInformationPage ownerInformationPage = addOwnerPage.clickSubmit();

        ownerInformationPage.verifyName("Hans Dampf");
        ownerInformationPage.verifyAddress("Elm Street");
        ownerInformationPage.verifyCity("thereCity");
        ownerInformationPage.verifyTelephone("987654321");
        return ownerInformationPage;
    }

    public static void createUser(WebDriver driver, String url) throws InterruptedException {
        Map<Integer,Map<String,String>> userData= new HashMap<Integer, Map<String, String>>();

        final HashMap<String, String> map = new HashMap<String, String>();
        map.put("registerView.userAddress.firstName", "Helmine");
        map.put("registerView.userAddress.lastName", "Stranger");
        map.put("registerView.userAddress.street", "SecretStreet");
        userData.put(1, map);

        driver.get(url + "/");
        driver.findElement(By.id("jRegisterLink")).click();
        new Select(driver.findElement(By.id("registerView.userAddress.gender"))).selectByVisibleText("Frau");
        driver.findElement(By.id("registerView.userAddress.gender")).click();

        final Map<String, String> map1 = userData.get(1);

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            driver.findElement(By.id(entry.getKey())).clear();
            driver.findElement(By.id(entry.getKey())).sendKeys(entry.getValue());
        }


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

        Assert.assertEquals("Helmine Stranger", driver.findElement(By.id("jUserArea")).getText());

    }

}
