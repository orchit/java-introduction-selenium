package de.orchit.java.selenium.pageobjects;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Homepage {

    private final WebDriver driver;
    private final String baseUrl;

    public Homepage(WebDriver driver, String url) {
        this.driver = driver;
        baseUrl = url;
    }

    public void goToPage(String lang) {
        driver.get(baseUrl +"/petclinic?lang="+ lang);
    }

    public void checkWelcomeMessage(String expected) {
        final List<WebElement> elements = driver.findElements(By.tagName("h2"));
        Assert.assertEquals(1, elements.size());
        Assert.assertEquals(expected, elements.get(0).getText());
    }

    public FindOwnersPage clickFindOwners() {
        driver.findElement(By.linkText("Find owners")).click();
        return new FindOwnersPage(driver,baseUrl);
    }
}
