package de.orchit.java.selenium.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOwnerPage extends BasePage {

    public AddOwnerPage(WebDriver newDriver, String newBaseUrl) {
        super(newDriver, newBaseUrl);
        driver.findElement(By.id("add-owner-form"));
    }

    public void setFirstName(String firstName) {
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        final By id = By.id("lastName");
        driver.findElement(id).clear();
        driver.findElement(id).sendKeys(lastName);
    }

    public void setAddress(String address) {
        final By id = By.id("address");
        driver.findElement(id).clear();
        driver.findElement(id).sendKeys(address);
    }

    public void setCity(String city) {
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);

    }

    public void setTelephone(String telephone) {
        driver.findElement(By.id("telephone")).clear();
        driver.findElement(By.id("telephone")).sendKeys(telephone);
    }

    public OwnerInformationPage clickSubmit() {
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        return new OwnerInformationPage(driver,baseUrl);
    }
}
