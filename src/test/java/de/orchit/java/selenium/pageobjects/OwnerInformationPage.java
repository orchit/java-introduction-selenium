package de.orchit.java.selenium.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class OwnerInformationPage {
    private final WebDriver driver;
    private final String baseUrl;

    public OwnerInformationPage(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        driver.findElement(By.linkText("Edit Owner"));
    }

    public void verifyName(String fullName) {
        assertEquals(fullName, driver.findElement(By.cssSelector("b")).getText());
    }

    public void verifyAddress(String address) {
        assertEquals(address, driver.findElement(By.xpath("//tr[2]/td")).getText());
    }

    public void verifyCity(String city) {
        assertEquals(city, driver.findElement(By.xpath("//tr[3]/td")).getText());
    }
    public void verifyTelephone(String telephone) {
        assertEquals(telephone, driver.findElement(By.xpath("//tr[4]/td")).getText());
    }

    public AddNewPetPage clickAddNewPet() {
        driver.findElement(By.linkText("Add New Pet")).click();
        return new AddNewPetPage(driver,baseUrl);
    }
}
