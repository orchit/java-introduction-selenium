package de.orchit.java.selenium.helper;

import de.orchit.java.selenium.pageobjects.AddOwnerPage;
import de.orchit.java.selenium.pageobjects.FindOwnersPage;
import de.orchit.java.selenium.pageobjects.Homepage;
import de.orchit.java.selenium.pageobjects.OwnerInformationPage;

/**
 * Created with IntelliJ IDEA.
 * User: pcornelissen
 * Date: 29.11.13
 * Time: 13:58
 * To change this template use File | Settings | File Templates.
 */
public class TestPreparationHelper {
    public static OwnerInformationPage prepareOwner(Homepage homepage) {
        final FindOwnersPage findOwnersPage = homepage.clickFindOwners();

        final AddOwnerPage addOwnerPage = findOwnersPage.clickAddOwner();

        addOwnerPage.setFirstName("Hans");
        addOwnerPage.setLastName("Dampf");
        addOwnerPage.setAddress("Elm Street");
        addOwnerPage.setCity("thereCity");
        addOwnerPage.setTelephone("987654321");

        final OwnerInformationPage ownerInformationPage = addOwnerPage.clickSubmit();

        ownerInformationPage.verifyName("Hans Dampf");
        ownerInformationPage.verifyAddress("Elm Street");
        ownerInformationPage.verifyCity("thereCity");
        ownerInformationPage.verifyTelephone("987654321");
        return ownerInformationPage;
    }
}
