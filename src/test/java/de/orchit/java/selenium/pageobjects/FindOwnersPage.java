package de.orchit.java.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FindOwnersPage extends BasePage{

    public FindOwnersPage(WebDriver driver, String url) {
        super(driver, url);
        driver.findElement(By.id("search-owner-form"));
    }

    public AddOwnerPage clickAddOwner() {
        driver.findElement(By.linkText("Add Owner")).click();
        return new AddOwnerPage(driver,baseUrl);
    }
}
