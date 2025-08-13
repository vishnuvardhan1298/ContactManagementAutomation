package com.cm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    private By logout = By.id("logout");
    private By contactListLink = By.id("contact-list-link");

    public NavigationPage(WebDriver driver) { super(driver); }

    public void logout() { click(logout); }
    public void goToContactList() { click(contactListLink); }
}

