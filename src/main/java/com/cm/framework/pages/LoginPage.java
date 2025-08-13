package com.cm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage extends BasePage {
    private By email = By.id("email");
    private By password = By.id("password");
    private By submit = By.id("submit");
    private By error = By.cssSelector(".error-message");

    public LoginPage(WebDriver driver) { super(driver); }

    public void open(String url) { driver.get(url); }

    public void login(String em, String pw) {
    	
    	// Wait until email field is visible before interacting
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(email));
    	
        type(email, em);
        type(password, pw);
        click(submit);
    }

    public String getError() { return isDisplayed(error) ? text(error) : ""; }

    public boolean isAt() { return isDisplayed(email); }
}
