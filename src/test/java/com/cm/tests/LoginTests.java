package com.cm.tests;

import com.cm.framework.pages.ContactPage;
import com.cm.framework.pages.LoginPage;
import com.cm.tests.base.BaseTest;
import com.cm.framework.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void verifyLoginWithValidCredentials() {
        // register a user first via registration test or reuse an existing account
        String em = TestData.randomEmail();
        String pw = TestData.get("default.password");

        // quick registration using registration page
        // (or call registration test methods) — here we use pageflow:
        com.cm.framework.pages.RegistrationPage reg = new com.cm.framework.pages.RegistrationPage(driver);
        reg.register("Auto","User", em, pw, pw);

        LoginPage login = new LoginPage(driver);
        login.login(em, pw);

        ContactPage cp = new ContactPage(driver);
        Assert.assertTrue(cp.isAtList(), "User should see contact list after login");
    }

    @Test
    public void verifyLoginWithIncorrectPassword() {
        String em = TestData.randomEmail();
        String pw = TestData.get("default.password");
        com.cm.framework.pages.RegistrationPage reg = new com.cm.framework.pages.RegistrationPage(driver);
        reg.register("Auto","User", em, pw, pw);

        LoginPage login = new LoginPage(driver);
        login.login(em, "WrongPassword!");
        Assert.assertTrue(login.getError().length() > 0, "Error message expected for wrong password");
    }

    @Test
    public void verifyLoginWithEmptyFields() {
        LoginPage login = new LoginPage(driver);
        login.login("", "");
        Assert.assertTrue(login.getError().length() > 0);
    }
}
