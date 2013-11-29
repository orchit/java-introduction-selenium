package de.orchit.java.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FindOwnersPage {
    private final WebDriver driver;
    private final String baseUrl;

    public FindOwnersPage(WebDriver driver, String url) {
        this.driver = driver;
        baseUrl = url;
        driver.findElement(By.id("search-owner-form"));
    }

    public void clickAddOwner() {
        driver.findElement(By.linkText("Add Owner")).click();
    }
}
