package de.orchit.java.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


public class AddNewPetPage extends BasePage{
    public AddNewPetPage(WebDriver newDriver, String newBaseUrl) {
        super(newDriver, newBaseUrl);
        driver.findElement(By.id("pet"));
        driver.findElement(By.id("owner"));
    }

    public void setName(String name) {
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys(name);
    }

   public void setBirthDate(String date) {
        driver.findElement(By.id("birthDate")).clear();
        driver.findElement(By.id("birthDate")).sendKeys(date);
    }

    public void selectPetType(String type) {
        new Select(driver.findElement(By.id("type"))).selectByVisibleText(type);
    }

    public void clickSubmit() {
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }

    public void verifyPetInformation(String petName, String birthDate, String type) {
        assertEquals(petName, driver.findElement(By.cssSelector("dd")).getText());
        assertEquals(birthDate, driver.findElement(By.xpath("//dd[2]")).getText());
        assertEquals(type, driver.findElement(By.xpath("//dd[3]")).getText());
        driver.findElement(By.linkText("Edit Pet"));
    }
}
