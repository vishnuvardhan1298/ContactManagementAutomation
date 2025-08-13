package com.cm.tests;

import com.cm.framework.pages.*;
import com.cm.framework.utils.TestData;
import com.cm.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationTests extends BaseTest {

    @Test
    public void verifyPhoneNumericValidation() {
        String em = TestData.randomEmail();
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("Val","User", em, TestData.get("default.password"), TestData.get("default.password"));
        LoginPage login = new LoginPage(driver);
        login.login(em, TestData.get("default.password"));

        ContactPage cp = new ContactPage(driver);
        cp.clickAdd();
        cp.addContact("Alpha","Beta","abcdef","alpha@ex.com","Addr");
        Assert.assertTrue(cp.getSuccess().length() == 0, "Non-numeric phone should fail");
    }

    @Test
    public void verifyUnicodeAndEmojiAddress() {
        String em = TestData.randomEmail();
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("Uni","Test", em, TestData.get("default.password"), TestData.get("default.password"));
        LoginPage login = new LoginPage(driver);
        login.login(em, TestData.get("default.password"));

        ContactPage cp = new ContactPage(driver);
        cp.clickAdd();
        cp.addContact("Emoji","Test", TestData.randomPhone(), "emoji@test.com", "हेलो 🌟");
        Assert.assertTrue(cp.getSuccess().length() > 0, "App should accept unicode/emoji if supported");
    }
}

