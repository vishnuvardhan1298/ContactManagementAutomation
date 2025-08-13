package com.cm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditContactPage extends BasePage {
    private By editButton = By.cssSelector(".edit-contact"); // per row
    private By lastName = By.id("lastName");
    private By save = By.id("save");
    private By cancel = By.id("cancel");
    private By error = By.cssSelector(".error-message");

    public EditContactPage(WebDriver driver) { super(driver); }

    public void clickEdit() { click(editButton); }
    public void updateLastName(String ln) { type(lastName, ln); }
    public void save() { click(save); }
    public void cancel() { click(cancel); }
    public String getError() { return isDisplayed(error) ? text(error) : ""; }
}
