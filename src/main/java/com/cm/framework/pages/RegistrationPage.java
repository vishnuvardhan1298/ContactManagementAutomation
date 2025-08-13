package com.cm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By submit = By.id("submit");
    private By error = By.cssSelector(".error-message");

    public RegistrationPage(WebDriver driver) { super(driver); }

    public void register(String fn, String ln, String em, String pw, String cpw) {
        type(firstName, fn);
        type(lastName, ln);
        type(email, em);
        type(password, pw);
        type(confirmPassword, cpw);
        click(submit);
    }

    public String getError() { return isDisplayed(error) ? text(error) : ""; }
}
