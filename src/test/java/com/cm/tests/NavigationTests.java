package com.cm.tests;

import com.cm.framework.pages.*;
import com.cm.framework.utils.TestData;
import com.cm.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    @Test
    public void verifyLogoutRedirectsToLogin() {
        String em = TestData.randomEmail();
        RegistrationPage reg = new RegistrationPage(driver);
        reg.register("Nav","User", em, TestData.get("default.password"), TestData.get("default.password"));
        LoginPage login = new LoginPage(driver);
        login.login(em, TestData.get("default.password"));

        NavigationPage nav = new NavigationPage(driver);
        nav.logout();

        Assert.assertTrue(new LoginPage(driver).isAt(), "Should return to login page after logout");
    }
}

