package com.cm.tests;

import com.cm.framework.pages.LoginPage;
import com.cm.framework.pages.RegistrationPage;
import com.cm.framework.utils.TestData;
import com.cm.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTest {

    @Test
    public void verifySignUpWithValidInputs() {
        String email = TestData.randomEmail();
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("First", "Last", email, TestData.get("default.password"), TestData.get("default.password"));

        // After registration many apps redirect to login
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.isAt(), "Login page displayed after registration");
    }

    @Test
    public void verifyRegistrationWithAlreadyRegisteredEmail() {
        String email = TestData.randomEmail();
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("A", "B", email, TestData.get("default.password"), TestData.get("default.password"));
        driver.get(baseUrl + "register"); // go to register page url if needed

        RegistrationPage reg2 = new RegistrationPage(driver);
        reg2.register("C", "D", email, TestData.get("default.password"), TestData.get("default.password"));
        Assert.assertTrue(reg2.getError().length() > 0, "Expected duplicate email error");
    }
}

