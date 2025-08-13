package com.cm.tests;

import com.cm.framework.pages.ContactPage;
import com.cm.framework.pages.LoginPage;
import com.cm.framework.pages.RegistrationPage;
import com.cm.framework.utils.TestData;
import com.cm.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateContactTests extends BaseTest {

    private void registerAndLogin(String em) {
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("Contact", "Creator", em, TestData.get("default.password"), TestData.get("default.password"));
        LoginPage login = new LoginPage(driver);
        login.login(em, TestData.get("default.password"));
    }

    @Test
    public void verifyAddingContactWithAllValidDetails() {
        String em = TestData.randomEmail();
        registerAndLogin(em);

        ContactPage cp = new ContactPage(driver);
        cp.clickAdd();
        cp.addContact("John","Doe", TestData.randomPhone(), "john.doe@example.com", "Some address");
        Assert.assertTrue(cp.getSuccess().length() > 0, "Success message should appear after adding contact");
    }

    @Test
    public void verifyAddingContactWithMissingRequiredFields() {
        String em = TestData.randomEmail();
        registerAndLogin(em);
        ContactPage cp = new ContactPage(driver);
        cp.clickAdd();
        // leave first/last blank:
        cp.addContact("","", TestData.randomPhone(), "no.name@example.com", "Addr");
        Assert.assertTrue(cp.getSuccess().length() == 0, "Should not succeed when required fields missing");
    }
}
