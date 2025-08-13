package com.cm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteContactPage {

    private WebDriver driver;

    // Example locators — replace with actual ones from your app
    private By deleteContactButton = By.id("deleteContact"); 
    private By confirmDeleteButton = By.id("confirmDelete");

    // Constructor
    public DeleteContactPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDeleteContact() {
        driver.findElement(deleteContactButton).click();
    }

    public void confirmDelete() {
        driver.findElement(confirmDeleteButton).click();
    }
}
