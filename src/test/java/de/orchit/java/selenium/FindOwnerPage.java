package de.orchit.java.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static junit.framework.TestCase.assertNotNull;

public class FindOwnerPage {
    WebDriver driver;

    public FindOwnerPage(WebDriver driver) {
        this.driver = driver;
        assertNotNull(driver.findElement(By.name("lastName")));

    }

    public void goToAddOwner() {
        driver.findElement(By.linkText("Add Owner")).click();
    }
}
