package de.orchit.java.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOwnerPage {
    WebDriver driver;

    public AddOwnerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String name) {
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(name);
    }

    public void setLastName(String name) {
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(name);
    }

    public void setAddress(String address) {
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys(address);
    }

    public void setCity(String city) {
        driver.findElement(By.id("city")).clear();
        driver.findElement(By.id("city")).sendKeys(city);
    }

    public void setTelephone(String number) {
        driver.findElement(By.id("telephone")).clear();
        driver.findElement(By.id("telephone")).sendKeys(number);
    }

    public void submit() {
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
    }

}
