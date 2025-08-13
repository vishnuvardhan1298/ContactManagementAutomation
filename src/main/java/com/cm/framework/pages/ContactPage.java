package com.cm.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {
    // adjust ids if site differs
    private By addBtn = By.id("add-contact");
    private By firstName = By.id("firstName");
    private By lastName = By.id("lastName");
    private By phone = By.id("phone");
    private By email = By.id("email");
    private By address = By.id("address");
    private By submit = By.id("submit");
    private By success = By.cssSelector(".success-message");
    private By contactList = By.id("contact-list"); // container for list

    public ContactPage(WebDriver driver) { super(driver); }

    public void clickAdd() { click(addBtn); }
    public void addContact(String fn, String ln, String ph, String em, String addr) {
        type(firstName, fn);
        type(lastName, ln);
        type(phone, ph);
        type(email, em);
        type(address, addr);
        click(submit);
    }
    public String getSuccess() { return isDisplayed(success) ? text(success) : ""; }
    public boolean isAtList() { return isDisplayed(contactList); }
}

