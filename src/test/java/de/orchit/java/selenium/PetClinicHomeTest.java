package de.orchit.java.selenium;


import de.orchit.java.selenium.helper.TestPreparationHelper;
import de.orchit.java.selenium.pageobjects.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PetClinicHomeTest {
    static WebDriver driver;
    private final String url;

    public PetClinicHomeTest() {
        url = "http://10.100.10.122:9966";
    }

    @BeforeClass
    public static void setup() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void checkHomepageForDE() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("de");
        homepage.checkWelcomeMessage("Willkommen");
    }

    @Test
    public void checkHomepageEN() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("en");
        homepage.checkWelcomeMessage("Welcome");
    }

    @Test
    public void createOwner() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("en");

        final FindOwnersPage findOwnersPage = homepage.clickFindOwners();

        final AddOwnerPage addOwnerPage = findOwnersPage.clickAddOwner();

        addOwnerPage.setFirstName("Hans");
        addOwnerPage.setLastName("Dampf");
        addOwnerPage.setAddress("Elm street");
        addOwnerPage.setCity("thereCity");
        addOwnerPage.setTelephone("987654321");

        final OwnerInformationPage ownerInformationPage = addOwnerPage.clickSubmit();

        ownerInformationPage.verifyName("Hans Dampf");
        ownerInformationPage.verifyAddress("Elm Street");
        ownerInformationPage.verifyCity("thereCity");
        ownerInformationPage.verifyTelephone("987654321");
    }


    @Test
    public void createPet() {
        final Homepage homepage = new Homepage(driver, url);
        homepage.goToPage("en");

        final OwnerInformationPage ownerInformationPage
                = TestPreparationHelper.prepareOwner(homepage);

        final AddNewPetPage addNewPetPage = ownerInformationPage.clickAddNewPet();

        addNewPetPage.setName("Tweety");
        addNewPetPage.setBirthDate("2011/11/01");
        addNewPetPage.selectPetType("bird");
        addNewPetPage.clickSubmit();

        addNewPetPage.verifyPetInformation("Tweety", "2011-10-31", "bird");

    }




}
