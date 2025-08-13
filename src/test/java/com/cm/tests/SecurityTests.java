package com.cm.tests;

import com.cm.framework.pages.LoginPage;
import com.cm.tests.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecurityTests extends BaseTest {

    @Test
    public void verifyLoginRequiredToAccessContactList() {
        // Try to navigate directly without login
        driver.get(baseUrl + "contact-list");
        Assert.assertTrue(new LoginPage(driver).isAt(), "Should redirect to login when accessing protected route");
    }
}

