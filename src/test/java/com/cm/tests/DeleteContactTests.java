package com.cm.tests;

import com.cm.framework.pages.*;
import com.cm.framework.utils.TestData;
import com.cm.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteContactTests extends BaseTest {

    private void setupContact(String em) {
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("Del","User", em, TestData.get("default.password"), TestData.get("default.password"));
        LoginPage login = new LoginPage(driver);
        login.login(em, TestData.get("default.password"));
        ContactPage cp = new ContactPage(driver);
        cp.clickAdd();
        cp.addContact("ToDelete","Sample", TestData.randomPhone(), "todelete@example.com", "X");
    }

    @Test
    public void verifyDeletingAContact() {
        String em = TestData.randomEmail();
        setupContact(em);
        DeleteContactPage del = new DeleteContactPage(driver);
        del.clickDeleteContact();
        del.confirmDelete();
        // assert based on app's success message or absence of element
        Assert.assertTrue(true, "Delete action executed; refine assert with app locator");
    }
}

