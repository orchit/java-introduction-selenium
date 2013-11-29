package de.orchit.java.selenium.pageobjects;

import org.openqa.selenium.WebDriver;

/**
 * Created with IntelliJ IDEA.
 * User: pcornelissen
 * Date: 29.11.13
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class BasePage {
    protected final WebDriver driver;
    protected final String baseUrl;

    public BasePage(WebDriver newDriver, String newBaseUrl) {
        baseUrl = newBaseUrl;
        driver = newDriver;
    }
}
