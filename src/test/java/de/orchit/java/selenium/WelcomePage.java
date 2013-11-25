package de.orchit.java.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage {
    WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        //verify that we are on the correct page, this waits for 10 sec
        //If the text is not found a timeout exception will occur
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.linkText("Find owners"))!=null;
            }
        });
    }

    public FindOwnerPage goToFindOwners(){
        driver.findElement(By.linkText("Find owners")).click();
        return new FindOwnerPage(driver);
    }

}
